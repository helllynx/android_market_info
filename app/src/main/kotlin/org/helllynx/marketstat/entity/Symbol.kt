package org.helllynx.marketstat.entity

import kotlinx.serialization.Serializable

@Serializable
data class Symbol(
    val symbol: String,
    val displaySymbol: String,
    val description: String
)
