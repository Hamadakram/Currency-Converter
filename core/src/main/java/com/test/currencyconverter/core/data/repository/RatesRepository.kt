package com.test.currencyconverter.core.data.repository

import com.test.currencyconverter.core.data.service.RateService
import javax.inject.Inject

/**
 * Created by Hammad Akram
 * hamadakram91@gmail.com
 */

class RatesRepository @Inject constructor(private val rateService: RateService) {
    fun getRates(currency: String) = rateService.getRates(currency)
}