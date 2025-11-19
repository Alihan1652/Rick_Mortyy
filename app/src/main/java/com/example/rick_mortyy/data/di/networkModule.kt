package com.example.rick_mortyy.data.di

import com.example.rick_mortyy.data.api.CartoonApi
import com.example.rick_mortyy.data.repository.CartoonRepositoryImpl
import com.example.rick_mortyy.domain.repository.CartoonRepository
import com.example.rick_mortyy.domain.usecases.GetCharacterUseCase
import com.example.rick_mortyy.presentation.viewmodel.CartoonViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    single { HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY } }

    single {
        OkHttpClient.Builder()
            .addInterceptor(get<HttpLoggingInterceptor>())
            .connectTimeout(20, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .writeTimeout(20, TimeUnit.SECONDS)
            .callTimeout(40, TimeUnit.SECONDS)
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single { get<Retrofit>().create(CartoonApi::class.java) }
}

val dataModule = module {
    single<CartoonRepository> { CartoonRepositoryImpl(get()) }
}

val domainModule = module {
    factory { GetCharacterUseCase(get()) }
}

val presentationModule = module {
    viewModel { CartoonViewModel(get()) }
}