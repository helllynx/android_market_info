package org.helllynx.marketstat.ui.main

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.helllynx.marketstat.R
import org.helllynx.marketstat.repository.MarketDataRepository
import org.helllynx.marketstat.utils.getColorCompat

class MarketListAdapter(private val expandable: Boolean, private val isPrintButtonVisible: Boolean) :
    RecyclerView.Adapter<MarketListAdapter.ItemViewHolder>() {

    private var expandedItem: ItemViewHolder? = null
    private var expandedHash: CharSequence? = null

    var transactions: List<MarketDataRepository.MarketData> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    interface OnMarketDataClickListener {
        fun onTransactionClick(marketData: MarketDataRepository.MarketData)
    }

    var onMarketDataClickListener: OnMarketDataClickListener? = null

    override fun getItemCount(): Int = transactions.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder = ItemViewHolder(
        MarketDataCard(parent.context)
    ).apply {
        itemView.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )

        card.setOnClickListener {
            onMarketDataClickListener?.onTransactionClick(transactions[adapterPosition])

        }
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        transactions[position].let { marketData ->
            holder.card.run {
                drawable = getDrawable(holder.itemView.context, marketData.confirmed)

            }
        }
    }

    private fun getDrawable(context: Context, confirmed: Boolean = true): Drawable? =
        if (confirmed) setTint(context.getColorCompat(R.color.success))
        else getDrawable(context, R.drawable.ic_waiting)?.apply { setTint(context.getColorCompat(R.color.waiting)) }

    class ItemViewHolder(val card: MarketDataCard) : RecyclerView.ViewHolder(card)
}
