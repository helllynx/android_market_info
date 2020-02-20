package org.helllynx.marketstat

import android.app.Application
import com.readystatesoftware.chuck.ChuckInterceptor
import org.helllynx.marketstat.repository.repositoryModule
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware

class MainApplication : Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        import(repositoryModule(this@MainApplication, "market_stat.db") { builder ->
            builder.addInterceptor(ChuckInterceptor(this@MainApplication))
        })
    }

    override fun onCreate() {
        super.onCreate()
        //UCEHandler.Builder(this)
        //.setTrackActivitiesEnabled(true)
        //.addCommaSeparatedEmailAddresses("")
        //.build()
    }
}
