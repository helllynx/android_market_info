package org.helllynx.marketstat.repository.network

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import okhttp3.MediaType
import okhttp3.OkHttpClient
import org.helllynx.marketstat.repository.network.finnhub.FinnHubNetwork
import org.helllynx.marketstat.repository.network.finnhub.api.FinnHubApi
import org.helllynx.marketstat.repository.network.serializer.asConverterFactory
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.multiton
import org.kodein.di.generic.singleton
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit


internal fun networkKodein(okHttpBuilder: (OkHttpClient.Builder) -> Unit = {}) = Kodein.direct {
    bind() from singleton { Json(JsonConfiguration.Stable.copy(strictMode = false)) }

    bind() from multiton { network: Network ->
        Retrofit.Builder()
            .baseUrl(network.url)
            .client(
                OkHttpClient.Builder()
                    .readTimeout(30, TimeUnit.SECONDS)
                    .addInterceptor(network.interceptor)
                    .apply(okHttpBuilder)
                    .build()
            )
            .addConverterFactory(instance<Json>().asConverterFactory(MediaType.get("application/json; charset=utf-8")))
            .build()
            .create(FinnHubApi::class.java)
    }

    bind<MarketInterface>() with multiton { network: Network ->
        when (network) {
            Network.FinnHubNetwork -> FinnHubNetwork(instance(arg = network))
        }
    }
}
