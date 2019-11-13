package com.test.currencyconverter.core.data.model

import com.google.gson.annotations.JsonAdapter
import com.test.currencyconverter.core.domain.RateList

/**
 * Created by Hammad Akram
 * hamadakram91@gmail.com
 */

data class RatesResponse(
    val base: String,
    val date: String,
    @JsonAdapter(RatesDeserializer::class)
    val rates: RateList
)