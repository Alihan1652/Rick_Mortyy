package com.example.rick_mortyy.data.di

import com.example.rick_mortyy.domain.usecases.GetCharacterByIdUseCase
import com.example.rick_mortyy.domain.usecases.GetCharacterUseCase
import org.koin.dsl.module

val domainModule = module {
    single { GetCharacterUseCase(repository = get()) }
    single { GetCharacterByIdUseCase(repository = get()) }
}