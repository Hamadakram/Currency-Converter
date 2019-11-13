package com.test.currencyconverter.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.test.currencyconverter.ui.RatesViewModel
import com.test.currencyconverter.di.ViewModelFactory
import com.test.currencyconverter.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by Hammad Akram
 * hamadakram91@gmail.com
 */

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(RatesViewModel::class)
    abstract fun provideRatesViewModel(ratesViewModel: RatesViewModel): ViewModel
}