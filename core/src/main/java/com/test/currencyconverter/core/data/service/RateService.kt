package com.test.currencyconverter.core.data.service

import com.test.currencyconverter.core.data.model.RatesResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Hammad Akram
 * hamadakram91@gmail.com
 */

interface RateService {
    @GET("/latest")
    fun getRates(@Query("base") currency: String): Single<RatesResponse>
}