package org.helllynx.marketstat.repository.network.finnhub.api

import org.helllynx.marketstat.entity.Quote
import org.helllynx.marketstat.entity.Symbol
import retrofit2.http.GET
import retrofit2.http.Query

internal interface FinnHubApi {

    @GET("api/v1/quote")
    suspend fun getQuote(
        @Query("symbol") symbol: String
    ): Quote

    @GET("api/v1/stock/symbol")
    suspend fun getSymbolsByExchange(
        @Query("exchange") exchange: String = "US"
    ): List<Symbol>
}
