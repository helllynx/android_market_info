package org.helllynx.marketstat.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import org.helllynx.marketstat.entity.Quote
import org.helllynx.marketstat.entity.Symbol
import org.helllynx.marketstat.repository.network.MarketInterface

class MarketDataRepository(
    private val api: MarketInterface
) {

    data class MarketData(val symbol: Symbol, val quote: Quote)

    lateinit var symbols: List<Symbol>

    init {
        GlobalScope.launch(Dispatchers.IO) {
            symbols = api.getSymbols()
        }
    }

    suspend fun getTicksAllSymbols(): Flow<MarketData> = flow {
        while (true) {
            api.getSymbols().map {
                emit(MarketData(it, api.getQuote(it.symbol)))
            }
            delay(GET_DATA_DELAY)
        }

    }

    companion object {
        private const val GET_DATA_DELAY = 10_000L
    }
}