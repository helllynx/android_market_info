package org.helllynx.marketstat.ui.main

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.annotation.DrawableRes
import com.google.android.material.card.MaterialCardView
import org.helllynx.marketstat.R
import org.helllynx.marketstat.utils.id

class MarketDataCard @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = R.attr.materialCardViewStyle
) : MaterialCardView(context, attrs, defStyleAttr) {

    private val ivIcon: ImageView by id(R.id.ct_icon)
    private val tvStatus: TextView by id(R.id.ct_status)
    private val tvTime: TextView by id(R.id.ct_time)
    private val tvAmount: TextView by id(R.id.ct_amount)
    private val tvFiatAmount: TextView by id(R.id.ct_fiat_amount)

    init {
        inflate(context, R.layout.card_transaction, this)

    }

    /**
     * @since 0.2.0
     */
    var drawable: Drawable?
        get() = ivIcon.drawable
        set(value) {
            ivIcon.setImageDrawable(value)
        }

    /**
     * @since 0.2.0
     */
    fun setDrawableResource(@DrawableRes resourceId: Int) {
        ivIcon.setImageResource(resourceId)
    }

    /**
     * @since 0.2.0
     */
    var status: CharSequence?
        get() = tvStatus.text
        set(value) {
            tvStatus.text = value
        }

    /**
     * @since 0.2.0
     */
    var time: CharSequence?
        get() = tvTime.text
        set(value) {
            tvTime.text = value
        }

    /**
     * @since 0.2.0
     */
    var amount: CharSequence?
        get() = tvAmount.text
        set(value) {
            tvAmount.text = value
        }

    /**
     * @since 0.2.0
     */
    var fiatAmount: CharSequence?
        get() = tvFiatAmount.text
        set(value) {
            tvFiatAmount.text = value
        }

    /**
     * Set tint to icon on card
     *
     * @since 0.2.0
     */
    @Deprecated(
        "Use imageTintList",
        ReplaceWith(
            "imageTintList = ColorStateList.valueOf(color)",
            "android.content.res.ColorStateList"
        ),
        DeprecationLevel.WARNING
    )
    fun setTint(@ColorInt color: Int) {
        ivIcon.imageTintList = ColorStateList.valueOf(color)
    }
}
