package com.example.rick_mortyy.data.di

import com.example.rick_mortyy.presentation.viewmodel.CharacterViewModel
import com.example.rick_mortyy.presentation.viewmodel.DetailCharacterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel {
        CharacterViewModel (
            getCharacterUseCase = get()
        )
    }
    viewModel {
        DetailCharacterViewModel(
            getCharacterByIdUseCase = get()
        )
    }
}