package com.test.currencyconverter.core.domain

import com.test.currencyconverter.core.domain.model.Rate

/**
 * Created by Hammad Akram
 * hamadakram91@gmail.com
 */

class RateList : ArrayList<Rate>() {
    fun updateRates(from: RateList) {
        val iterate = from.listIterator()
        while (iterate.hasNext()) {
            val rate = iterate.next()
            val index = this.indexOf(rate)
            if (index != -1) {
                this[index] = rate
                iterate.remove()
            }
        }
        this.addAll(from)
    }

    fun move(from: Int, to: Int) {
        val rateItem = this[from]
        this.removeAt(from)
        this.add(to, rateItem)
    }

    override fun indexOf(element: Rate): Int {
        for ((index, value) in this.withIndex()) {
            if (value.currency == element.currency)
                return index
        }
        return -1
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other?.javaClass != javaClass) return false

        other as RateList
        if (size == other.size) {
            for ((index, value) in this.withIndex()) {
                if(value.currency != other[index].currency){
                    return false
                }
            }
        }else{
            return false
        }
        return true
    }

}