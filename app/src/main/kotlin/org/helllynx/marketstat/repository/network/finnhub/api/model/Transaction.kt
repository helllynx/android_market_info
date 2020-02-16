package org.helllynx.marketstat.repository.network.finnhub.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class Transaction(

    @SerialName("hash")
    val hash: String,


    @SerialName("height")
    val height: Long

)


