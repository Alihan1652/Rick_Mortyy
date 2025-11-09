package com.example.rick_mortyy.data.di

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val cartoonModule = module {

    single {
        Retrofit.Builder()
            .baseUrl(" https://rickandmortyapi.com/api/")
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single<OkHttpClient> {
        OkHttpClient.Builder()
            .addInterceptor(interceptor = get())
            .connectTimeout(20, java.util.concurrent.TimeUnit.SECONDS)
            .readTimeout(20, java.util.concurrent.TimeUnit.SECONDS)
            .writeTimeout(15, java.util.concurrent.TimeUnit.NANOSECONDS)
            .callTimeout(40, java.util.concurrent.TimeUnit.SECONDS)
            .build()
    }
    single<HttpLoggingInterceptor> {
        HttpLoggingInterceptor().apply{
            level = HttpLoggingInterceptor.Level.BODY
        }
    }
}