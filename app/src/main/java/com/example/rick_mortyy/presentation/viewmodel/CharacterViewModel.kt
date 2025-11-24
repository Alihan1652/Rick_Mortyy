package com.example.rick_mortyy.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rick_mortyy.core.Either
import com.example.rick_mortyy.domain.models.Character
import com.example.rick_mortyy.domain.usecases.GetCharacterUseCase
import com.example.rick_mortyy.presentation.utils.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class CharacterViewModel(
    private val getCharacterUseCase: GetCharacterUseCase
): ViewModel() {

    private val _charactersState = MutableStateFlow<UiState<List<Character>>>(UiState.Empty)
    val charactersState = _charactersState.asStateFlow()

    fun getCharacters() {
        viewModelScope.launch {
            getCharacterUseCase.getCharacters()
                .onStart {
                    _charactersState.value = UiState.Loading
                }
                .collect { result ->
                    when(result) {
                        is Either.Left -> {
                           _charactersState.value = UiState.Error(result.value)
                        }

                        is Either.Right -> {
                            _charactersState.value = UiState.Success(result.value)

                        }
                    }
                }
        }
    }
}