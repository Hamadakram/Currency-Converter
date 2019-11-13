package com.test.currencyconverter.di.component

import android.content.Context
import com.test.currencyconverter.ui.RatesActivity
import com.test.currencyconverter.ui.RatesFragment
import com.test.currencyconverter.di.module.NetworkModule
import com.test.currencyconverter.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Hammad Akram
 * hamadakram91@gmail.com
 */

@Singleton
@Component(modules = [NetworkModule::class, ViewModelModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun inject(ratesActivity: RatesActivity)
    fun inject(ratesFragment: RatesFragment)
}