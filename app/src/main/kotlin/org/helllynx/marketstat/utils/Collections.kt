package org.helllynx.marketstat.utils

/**
 * @since 0.1.0
 */
infix fun <X, Y> List<X>.combinedWith(other: List<Y>): List<Pair<X, Y>> =
    mutableListOf<Pair<X, Y>>().also {
        forEach { first -> other.forEach { second -> it.add(first to second) } }
    }
