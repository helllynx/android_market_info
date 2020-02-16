package org.helllynx.marketstat.utils

import android.app.Activity
import android.view.View
import androidx.annotation.IdRes
import androidx.core.app.ActivityCompat

/**
 * Wrapper [ActivityCompat.requireViewById]
 *
 * @return View
 * @param id id View
 * @since 0.0.0
 */
fun <T : View> Activity.requireViewByIdCompat(@IdRes id: Int) =
    ActivityCompat.requireViewById<T>(this, id)
