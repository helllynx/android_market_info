package org.helllynx.marketstat.repository.network

import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Response
import org.helllynx.marketstat.entity.Quote
import org.helllynx.marketstat.entity.Symbol


interface MarketInterface {

    suspend fun getSymbols(): List<Symbol>

    suspend fun getQuote(symbol: String): Quote
}


enum class Network(
    val title: String, val url: String, val interceptor: (Interceptor.Chain) -> Response = { chain ->
        val request = chain.request().newBuilder().build()
        chain.proceed(request)
    }
) {
    FinnHubNetwork("FinnHub", "https://finnhub.io/", { chain ->
        val original = chain.request()
        val originalHttpUrl: HttpUrl = original.url()

        val url = originalHttpUrl.newBuilder()
            .addQueryParameter("token", "bp4rk3nrh5rfu45l0900")
            .build()

        val requestBuilder = original.newBuilder()
            .url(url)

        val request = requestBuilder.build()
        chain.proceed(request)
    })


}
