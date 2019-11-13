package com.test.currencyconverter.core.domain.interactor

import com.test.currencyconverter.core.data.repository.RatesRepository
import com.test.currencyconverter.core.domain.model.Rate
import javax.inject.Inject

/**
 * Created by Hammad Akram
 * hamadakram91@gmail.com
 */

class GetRatesUseCase @Inject constructor(private val ratesRepository: RatesRepository) {
    fun getRates(currency: String) = ratesRepository.getRates(currency).map { ratesResponse ->
        return@map ratesResponse.rates.also { rateList ->
            rateList.add(0,
                Rate(ratesResponse.base, 1f)
            )
        }
    }
}