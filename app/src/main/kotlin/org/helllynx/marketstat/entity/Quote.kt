package org.helllynx.marketstat.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Quote(
    @SerialName("o")
    val openPrice: Float,
    @SerialName("h")
    val highPrice: Float,
    @SerialName("l")
    val lowPrice: Float,
    @SerialName("c")
    val currentPrice: Float,
    @SerialName("pc")
    val previousClosePrice: Float
)