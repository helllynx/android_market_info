package org.helllynx.marketstat.utils

import android.content.Context
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import java.io.File

/**
 * [ContextCompat.getColor] wrapper
 *
 * @param id color id
 * @return color
 * @since 0.0.0
 */
fun Context.getColorCompat(@ColorRes id: Int) = ContextCompat.getColor(this, id)

/**
 * [ContextCompat.getDrawable] wrapper
 *
 * @param id color id
 * @return color
 * @since 0.0.1
 */
fun Context.getDrawableCompat(@DrawableRes id: Int) = ContextCompat.getDrawable(this, id)

/**
 * Clears application data
 *
 * @since 0.0.0
 */
fun Context.clearApplicationData() {

    fun deleteFile(file: File) {
        if (file.isDirectory) file.list()?.forEach { deleteFile(File(file, it)) }
        else file.delete()
    }

    val applicationDirectory = cacheDir.parent?.let { File(it) }
    if (applicationDirectory?.exists() == true) {
        applicationDirectory.list()?.filter { it != "lib" }?.forEach {
            deleteFile(File(applicationDirectory, it))
        }
    }
}
