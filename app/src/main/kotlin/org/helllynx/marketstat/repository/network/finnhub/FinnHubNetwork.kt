package org.helllynx.marketstat.repository.network.finnhub

import kotlinx.coroutines.coroutineScope
import org.helllynx.marketstat.entity.Quote
import org.helllynx.marketstat.entity.Symbol
import org.helllynx.marketstat.repository.network.MarketInterface
import org.helllynx.marketstat.repository.network.finnhub.api.FinnHubApi

internal class FinnHubNetwork(
    private val api: FinnHubApi
) : MarketInterface {
    override suspend fun getSymbols(): List<Symbol> = coroutineScope {
        api.getSymbolsByExchange()
    }

    override suspend fun getQuote(symbol: String): Quote = coroutineScope {
        api.getQuote(symbol)
    }

}
