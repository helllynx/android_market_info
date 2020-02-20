package org.helllynx.marketstat.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import org.helllynx.marketstat.repository.MarketDataRepository
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance

class MarketFragmentViewModel(application: Application) : AndroidViewModel(application), KodeinAware {

    override val kodein: Kodein by kodein()

    private val networkRepository: MarketDataRepository by instance()

    //private val selectedNetworksIds = networkRepository.getSelectedLiveData().map { networks -> networks.map { it.id } }

    //val tokens = selectedNetworksIds.map { networkIds ->
    //    networkIds.map { tokenRepository.getByNetworkIdLiveData(it) }
    //}.flatten().map { tokens -> tokens.flatten().associateBy { it.id } }
    //
    //val transactions = selectedNetworksIds.switchMap { transactionsRepository.getTransactionsLiveData(it) }
}
