package com.test.currencyconverter.core.domain.model

/**
 * Created by Hammad Akram
 * hamadakram91@gmail.com
 */

data class Rate(
    val currency: String,
    val rate: Float
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other?.javaClass != javaClass) return false

        other as Rate
        if (currency != other.currency) return false
        if (rate != other.rate) return false
        return true
    }

    override fun hashCode(): Int {
        var result = currency.hashCode()
        result = 31 * result + rate.hashCode()
        return result
    }
}