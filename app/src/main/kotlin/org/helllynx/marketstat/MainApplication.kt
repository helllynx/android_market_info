package org.helllynx.marketstat

import android.app.Application
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware

class MainApplication : Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        //import(repositoryModule(this@MainApplication, "wallet.db") { builder ->
        //    builder.addInterceptor(ChuckInterceptor(this@MainApplication))
        //})
        //import(keyManagerModule)
    }

    override fun onCreate() {
        super.onCreate()
        //UCEHandler.Builder(this)
        //.setTrackActivitiesEnabled(true)
        //.addCommaSeparatedEmailAddresses("")
        //.build()
    }
}
