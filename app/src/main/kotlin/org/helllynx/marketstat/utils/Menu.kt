package org.helllynx.marketstat.utils

import android.view.Menu
import androidx.annotation.ColorInt
import androidx.core.graphics.drawable.DrawableCompat
import androidx.core.view.forEach

/**
 * Sets color of menu icons
 *

 * @since 0.0.0
 */
fun Menu.setColor(@ColorInt color: Int) =
    forEach { item -> item.icon.also { DrawableCompat.setTint(it, color) } }
