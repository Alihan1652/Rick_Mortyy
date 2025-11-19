package com.example.rick_mortyy.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rick_mortyy.core.Either
import com.example.rick_mortyy.domain.models.Character
import com.example.rick_mortyy.domain.usecases.GetCharacterUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CartoonViewModel(
    private val getCharacterUseCase: GetCharacterUseCase
): ViewModel() {

    private val _characterState = MutableStateFlow<List<Character>>(emptyList())
    val charactersState = _characterState.asStateFlow()

    fun getCharacters() {
        viewModelScope.launch {

            getCharacterUseCase.getCharacters()
                .collect { result ->
               when(result){
                   is Either.Left -> {

                   }
                   is Either.Right -> {
                       _characterState.value = result.value
                   }
               }
            }
        }
    }
}