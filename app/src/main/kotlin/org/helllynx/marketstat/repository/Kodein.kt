package org.helllynx.marketstat.repository

import android.app.Application
import okhttp3.OkHttpClient
import org.helllynx.marketstat.repository.network.networkKodein
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton
import org.kodein.di.weakReference


fun repositoryModule(
    application: Application,
    databaseName: String,
    okHttpBuilder: (OkHttpClient.Builder) -> Unit = {}
) = Kodein.Module(name = "RepositoryModule") {
    val net = networkKodein(okHttpBuilder)
    bind() from singleton(ref = weakReference) {
        MarketDataRepository(net.instance())
    }

}
