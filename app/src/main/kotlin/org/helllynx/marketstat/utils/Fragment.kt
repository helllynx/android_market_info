package org.helllynx.marketstat.utils

import android.view.View
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

private class IdDelegate<T : View>(
    private val fragment: Fragment,
    @IdRes private val id: Int
) : ReadOnlyProperty<Any?, T>, LifecycleObserver {

    private var value: T? = null

    init {
        fragment.viewLifecycleOwnerLiveData.observe(fragment) { lifecycleOwner ->
            lifecycleOwner.lifecycle.addObserver(this)
        }
    }

    @Suppress("unused")
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private fun onDestroy() {
        value = null
    }

    override fun getValue(thisRef: Any?, property: KProperty<*>) = checkNotNull(
        value ?: fragment.requireView().requireViewByIdCompat<T>(id).also { value = it }
    )
}

/**
 * Creates delegate that keeps [View] reference actual
 *
 * If [View] is in [Lifecycle.State.DESTROYED] state while accessing property an exception will be thrown
 *
 * @receiver fragment, that contains View
 * @param T View type
 * @param id View id
 * @since 0.0.0
 */
fun <T : View> Fragment.id(@IdRes id: Int): ReadOnlyProperty<Any?, T> = IdDelegate(this, id)
