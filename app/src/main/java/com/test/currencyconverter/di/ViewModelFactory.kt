package com.test.currencyconverter.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.MapKey
import javax.inject.Inject
import javax.inject.Provider
import kotlin.reflect.KClass

/**
 * Created by Hammad Akram
 * hamadakram91@gmail.com
 */

class ViewModelFactory @Inject constructor(private val creators: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>) :
    ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        var creator = creators[modelClass]

        if (creator == null) {
            creators.forEach {
                if (modelClass.isAssignableFrom(it.key)) {
                    creator = it.value
                    return@forEach
                }
            }
        }
        val finalCreator = creator
            ?: throw IllegalArgumentException("Unknown model class $modelClass")

        return finalCreator.get() as T
    }
}

@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
@MapKey
internal annotation class ViewModelKey(val value: KClass<out ViewModel>)