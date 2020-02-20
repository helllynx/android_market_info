package org.helllynx.marketstat.entity

import kotlinx.serialization.Serializable

@Serializable
data class Quote(
    val openPrice: Float,
    val highPrice: Float,
    val lowPrice: Float,
    val currentPrice: Float,
    val previousClosePrice: Float
)