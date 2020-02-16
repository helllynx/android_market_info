package org.helllynx.marketstat.utils

import android.widget.BaseAdapter

/**
 * @since 0.0.0
 */
abstract class GenericBaseAdapter<T> : BaseAdapter() {
    abstract override fun getItem(position: Int): T
}
