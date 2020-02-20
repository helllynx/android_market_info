package org.helllynx.marketstat.ui.main

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import org.helllynx.marketstat.R
import org.helllynx.marketstat.utils.requireViewByIdCompat

class MarketFragment : Fragment(R.layout.fragment_market) {

    private val viewModel by viewModels<MarketFragmentViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        view.requireViewByIdCompat<Toolbar>(R.id.ftr_toolbar).apply {
            (requireActivity() as AppCompatActivity).setSupportActionBar(this)
        }

        //view.requireViewByIdCompat<RecyclerView>(R.id.ftr_recycler_view).apply {
        //    adapter = MarketListAdapter(expandable = true, isPrintButtonVisible = false).apply {
        //
        //        viewModel.tokens.observe(viewLifecycleOwner) { tokenMap = it }
        //        viewModel.transactions.observe(viewLifecycleOwner) { transactions = it }
        //    }
        //
        //    layoutManager = LinearLayoutManager(requireContext())
        //    addItemDecoration(SpacingItemDecoration(dimen(R.dimen.cards_spacing)))
        //}
    }
}