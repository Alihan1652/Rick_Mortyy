package com.example.rick_mortyy.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rick_mortyy.core.Either
import com.example.rick_mortyy.domain.models.Character
import com.example.rick_mortyy.domain.usecases.GetCharacterUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

data class UiState<T>(
    val isLoading: Boolean = false,
    val data: T? = null,
    val error: String? = null
)

class CartoonViewModel(
    private val getCharacterUseCase: GetCharacterUseCase
): ViewModel() {

    private val _characterState = MutableStateFlow(UiState<List<Character>>(isLoading = false))
    val charactersState = _characterState.asStateFlow()

    fun getCharacters() {
        viewModelScope.launch {
            _characterState.value = UiState(isLoading = true)

            getCharacterUseCase.getCharacters()
                .collect { result ->
                    when(result) {
                        is Either.Left -> {
                            _characterState.value = UiState(isLoading = false, error = result.value)
                        }
                        is Either.Right -> {
                            _characterState.value = UiState(isLoading = false, data = result.value)
                        }
                    }
                }
        }
    }
}