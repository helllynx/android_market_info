package org.helllynx.marketstat.repository.database

import android.app.Application
import org.kodein.di.Kodein

internal fun databaseKodein(application: Application, databaseName: String) = Kodein.direct {
    //    bind() from singleton {
//        Room.databaseBuilder(
//            application,
//            Database::class.java,
//            databaseName
//        ).addCallback(DatabaseCreateCallback).build()
//    }
//
//    bind() from provider { instance<Database>().accountDao }
//    bind() from provider { instance<Database>().tokenDao }
//    bind() from provider { instance<Database>().transactionDao }
//    bind() from provider { instance<Database>().networkDao }
//
//    bind() from provider { instance<Database>().balanceDao }
}
