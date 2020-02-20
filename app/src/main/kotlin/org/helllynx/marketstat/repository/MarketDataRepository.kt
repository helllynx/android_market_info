package org.helllynx.marketstat.repository

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.helllynx.marketstat.entity.Quote
import org.helllynx.marketstat.entity.Symbol
import org.helllynx.marketstat.repository.network.MarketInterface

class MarketDataRepository(
    private val api: MarketInterface
) {

    data class MarketData(val symbol: Symbol, val quote: Quote)

    lateinit var symbols: List<Symbol>

    init {
        //GlobalScope.launch(Dispatchers.IO) {
        //    symbols = api.getSymbols()
        //}

        symbols = listOf(
            Symbol("AAPL", "", ""),
            Symbol("TSLA", "", ""),
            Symbol("NVDA", "", ""),
            Symbol("AMD", "", "")
        )
    }

    suspend fun getTicksAllSymbols(): Flow<List<MarketData>> = flow {
        while (true) {
            emit(symbols.map {
                MarketData(it, api.getQuote(it.symbol))
            }.toList())
            delay(GET_DATA_DELAY)
        }

    }

    companion object {
        private const val GET_DATA_DELAY = 10_000L
    }
}