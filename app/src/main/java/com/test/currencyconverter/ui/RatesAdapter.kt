package com.test.currencyconverter.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.test.currencyconverter.R
import com.test.currencyconverter.core.domain.model.Rate


/**
 * Created by Hammad Akram
 * hamadakram91@gmail.com
 */

class RatesAdapter : RecyclerView.Adapter<RateViewHolder>() {

    var onItemSelected: ((item: Rate, position: Int) -> Unit)? = null
    var onValueChanged: ((Float) -> Unit)? = null
    var onMultiplierChange: ((Float) -> Unit)? = null
    var multiplier: Float = 1f
    private var rateList: List<Rate> = emptyList()
    private var oldRateList: List<Rate> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RateViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return RateViewHolder(view)
    }

    override fun onBindViewHolder(holder: RateViewHolder, position: Int) {
        holder.bind(
            getItem(position),
            multiplier,
            onItemSelected,
            onValueChanged,
            onMultiplierChange
        )
    }

    override fun getItemCount(): Int = rateList.size

    private fun getItem(position: Int) = rateList[position]
    private fun getOldItem(position: Int) = oldRateList[position]

    fun updateList(rateList: List<Rate>) {
        this.rateList = rateList
    }

    fun notifyDataChanged() {
        if (oldRateList.size == rateList.size) {
            for ((index, value) in rateList.withIndex()) {
                if (getOldItem(index) != value) {
                    notifyItemChanged(index)
                }
            }
        } else {
            notifyDataSetChanged()
        }
        this.oldRateList = rateList
    }

    fun notifyItemsChanged(exceptPosition: Int) {
        for (index in 1 until itemCount) {
            if (index != exceptPosition)
                notifyItemChanged(index)
        }
    }

}