package com.test.currencyconverter.di.module

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.test.currencyconverter.core.data.service.RateService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by Hammad Akram
 * hamadakram91@gmail.com
 */

@Module
class NetworkModule {

    companion object {
        private const val BASE_URL = "https://revolut.duckdns.org"
    }

    @Singleton
    @Provides
    fun provideRateService(retrofit: Retrofit): RateService {
        return retrofit.create(RateService::class.java)
    }

    @Singleton
    @Provides
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().apply {
            connectTimeout(10, TimeUnit.SECONDS)
            readTimeout(10, TimeUnit.SECONDS)
            writeTimeout(10, TimeUnit.SECONDS)
        }.build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(client: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder().apply {
            client(client)
            baseUrl(BASE_URL)
            addConverterFactory(GsonConverterFactory.create(gson))
            addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
        }.build()
    }
}