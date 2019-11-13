package com.test.currencyconverter.di

import android.app.Activity
import androidx.fragment.app.Fragment
import com.test.currencyconverter.di.component.AppComponent

/**
 * Created by hammad.akram
 * hamadakram91@gmail.com
 */

interface DaggerComponentProvider {
    val appComponent: AppComponent
}

val Activity.injector get() = (application as DaggerComponentProvider).appComponent
val Fragment.injector get() = (activity?.application as DaggerComponentProvider).appComponent