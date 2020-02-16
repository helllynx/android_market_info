package org.helllynx.marketstat.utils

private val lineSeparator = checkNotNull(System.getProperty("line.separator"))

/**
 * @since 0.0.0
 */
fun String.toSingleLine() = replace(lineSeparator, " ")
