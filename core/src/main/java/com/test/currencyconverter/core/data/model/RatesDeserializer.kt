package com.test.currencyconverter.core.data.model

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.test.currencyconverter.core.domain.model.Rate
import com.test.currencyconverter.core.domain.RateList
import java.lang.reflect.Type

/**
 * Created by Hammad Akram
 * hamadakram91@gmail.com
 */

class RatesDeserializer : JsonDeserializer<RateList> {

    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): RateList {
        val rates = RateList()

        val currencyKeys = json?.asJsonObject?.keySet()
        currencyKeys?.forEach {
            rates.add(
                Rate(
                    it,
                    json.asJsonObject.get(it).asFloat
                )
            )
        }
        return rates
    }

}