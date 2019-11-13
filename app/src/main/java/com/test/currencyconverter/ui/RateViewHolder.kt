package com.test.currencyconverter.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.test.currencyconverter.core.domain.model.Rate
import com.test.currencyconverter.getCurrencyName
import com.test.currencyconverter.getFlag
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.list_item.view.*


/**
 * Created by Hammad Akram
 * hamadakram91@gmail.com
 */

class RateViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
    LayoutContainer {

    fun bind(
        model: Rate,
        multiplier: Float,
        onItemSelected: ((item: Rate, position: Int) -> Unit)?,
        onValueChanged: ((Float) -> Unit)?,
        onMultiplierChange: ((Float) -> Unit)?
    ) {
        itemView.tvCurrency.text = model.currency
        itemView.tvCurrencyName.text = model.getCurrencyName()
        model.getFlag()?.let {
            itemView.icCurrency.setImageResource(it)
        }

        itemView.etRate.setRate(model.rate, multiplier)

        itemView.etRate.onFocus = {
            onMultiplierChange?.invoke(it)
            onItemSelected?.invoke(model, adapterPosition)
        }

        itemView.etRate.onTextChange = {
            onMultiplierChange?.invoke(it)
            onValueChanged?.invoke(it)
        }
    }
}