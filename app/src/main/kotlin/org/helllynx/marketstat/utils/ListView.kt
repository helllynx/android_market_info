package org.helllynx.marketstat.utils

import android.widget.ListView

/**
 * @since 0.0.0
 */
var ListView.scrollPosition: Pair<Int, Int>
    get() = firstVisiblePosition to (getChildAt(0)?.top ?: paddingTop) - paddingTop
    set(value) = setSelectionFromTop(value.first, value.second)
