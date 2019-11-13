package com.test.currencyconverter

import com.test.currencyconverter.core.domain.model.Rate

/**
 * Created by Hammad Akram
 * hamadakram91@gmail.com
 */

fun Rate.getFlag() = currencyFlags[currency]
fun Rate.getCurrencyName() = currencyName[currency]

private val currencyFlags = hashMapOf(
    "AUD" to R.drawable.ic_aud,
    "BGN" to R.drawable.ic_bgn,
    "BRL" to R.drawable.ic_brl,
    "CAD" to R.drawable.ic_cad,
    "CHF" to R.drawable.ic_chf,
    "CNY" to R.drawable.ic_cny,
    "CZK" to R.drawable.ic_czk,
    "DKK" to R.drawable.ic_dkk,
    "EUR" to R.drawable.ic_eur,
    "GBP" to R.drawable.ic_gbp,
    "HKD" to R.drawable.ic_hkd,
    "HRK" to R.drawable.ic_hrk,
    "HUF" to R.drawable.ic_huf,
    "IDR" to R.drawable.ic_idr,
    "ILS" to R.drawable.ic_ils,
    "INR" to R.drawable.ic_inr,
    "ISK" to R.drawable.ic_isk,
    "JPY" to R.drawable.ic_jpy,
    "KRW" to R.drawable.ic_krw,
    "MXN" to R.drawable.ic_mxn,
    "MYR" to R.drawable.ic_myr,
    "NOK" to R.drawable.ic_nok,
    "NZD" to R.drawable.ic_nzd,
    "PHP" to R.drawable.ic_php,
    "PLN" to R.drawable.ic_pln,
    "RON" to R.drawable.ic_ron,
    "RUB" to R.drawable.ic_rub,
    "SEK" to R.drawable.ic_sek,
    "SGD" to R.drawable.ic_sgd,
    "THB" to R.drawable.ic_thb,
    "TRY" to R.drawable.ic_try,
    "USD" to R.drawable.ic_usd,
    "ZAR" to R.drawable.ic_zar
)

private val currencyName = hashMapOf(
    "AUD" to "Australian Dollar",
    "BGN" to "Bulgarian Lev",
    "BRL" to "Brazilian Real",
    "CAD" to "Canadian Dollar",
    "CHF" to "Swiss Frank",
    "CNY" to "Chinese Yuan",
    "CZK" to "Czech Koruna",
    "DKK" to "Danish Krone",
    "EUR" to "Euro",
    "GBP" to "Pound Sterling",
    "HKD" to "Hong Kong Dollar",
    "HRK" to "Croatian Kuna",
    "HUF" to "Hungarian Forint",
    "IDR" to "Indonesian Rupiah",
    "ILS" to "Israeli New Shekel",
    "INR" to "Indian Rupee",
    "ISK" to "Icelandic Krona",
    "JPY" to "Japanese Yen",
    "KRW" to "South Korean Won",
    "MXN" to "Mexican Peso",
    "MYR" to "Malaysian Ringgit",
    "NOK" to "Norwegian Krone",
    "NZD" to "New Zealand Dollar",
    "PHP" to "Philippine Peso",
    "PLN" to "Polish Zloty",
    "RON" to "Romanian Leu",
    "RUB" to "Russian Ruble",
    "SEK" to "Swedish Krona",
    "SGD" to "Singapore Dollar",
    "THB" to "Thai Baht",
    "TRY" to "Turkish Lira",
    "USD" to "US Dollar",
    "ZAR" to "South African Rand"
)