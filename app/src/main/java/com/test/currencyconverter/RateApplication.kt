package com.test.currencyconverter

import android.app.Application
import com.test.currencyconverter.di.DaggerComponentProvider
import com.test.currencyconverter.di.component.AppComponent
import com.test.currencyconverter.di.component.DaggerAppComponent

/**
 * Created by Hammad Akram
 * hamadakram91@gmail.com
 */

class RateApplication : Application(), DaggerComponentProvider {

    override val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(applicationContext)
    }
}