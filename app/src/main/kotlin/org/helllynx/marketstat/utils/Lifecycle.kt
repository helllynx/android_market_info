package ru.azur.wechatpos.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.distinctUntilChanged
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

// region distinctUntilChanged

/**
 * @since 0.0.2
 */
fun <T> LiveData<T>.distinctUntilChanged(checker: (newValue: T) -> Boolean) =
    MediatorLiveData<T>().apply {
        addSource(this@distinctUntilChanged.distinctUntilChanged()) { newValue ->
            if (!checker(
                    newValue
                )
            ) value = newValue
        }
    }

// endregion

// region flatten

/**
 * @since 0.0.4
 */
@JvmName("flattenList")
fun <T : Any> LiveData<List<LiveData<T>>>.flatten(): LiveData<List<T>> =
    MediatorLiveData<List<T>>().apply {
        val sources = mutableListOf<LiveData<T>>()
        addSource(this@flatten) { list ->
            sources.forEach { removeSource(it) }
            sources.clear()

            list.forEach { source ->
                addSource(source) addSourceInternal@{
                    value =
                        this@flatten.value?.map { value -> value.value ?: return@addSourceInternal }
                }
                sources += source
            }
        }
    }

/**
 * @since 0.0.4
 */
@JvmName("flattenMap")
fun <X, Y : Any> LiveData<Map<X, LiveData<Y>>>.flatten(): LiveData<Map<X, Y>> =
    MediatorLiveData<Map<X, Y>>().apply {
        val sources = mutableListOf<LiveData<Y>>()
        addSource(this@flatten) { map ->
            sources.forEach { removeSource(it) }
            sources.clear()

            map.values.forEach { source ->
                addSource(source) addSourceInternal@{
                    value = this@flatten.value?.mapValues { (_, value) ->
                        value.value ?: return@addSourceInternal
                    }
                }
                sources += source
            }
        }
    }

// endregion

// region Suspend transformations

/**
 * @since 0.0.3
 */
fun <X, Y> LiveData<X>.map(
    coroutineScope: CoroutineScope,
    transformation: suspend (X) -> Y
): LiveData<Y> = MediatorLiveData<Y>().apply {
    addSource(this@map) { newValue -> coroutineScope.launch { value = transformation(newValue) } }
}

// endregion
