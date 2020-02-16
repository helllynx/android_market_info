package org.helllynx.marketstat.repository

import android.app.Application
import org.kodein.di.Kodein


fun repositoryModule(
    application: Application,
    databaseName: String,
    url: String
) = Kodein.Module(name = "RepositoryModule") {


}
