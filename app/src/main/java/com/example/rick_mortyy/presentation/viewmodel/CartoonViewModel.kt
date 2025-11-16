package com.example.rick_mortyy.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rick_mortyy.domain.usecases.GetCharacterUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CartoonViewModel(
    private val getCharecterUseCase: GetCharacterUseCase
) : ViewModel() {
    private val _charactersState = MutableStateFlow<List<String>>(emptyList())
    val charactersState: StateFlow<List<String>> = _charactersState.asStateFlow()

    fun getCharacters() {
        viewModelScope.launch {
            getCharecterUseCase.getCharacters().collect { data->
                _charactersState.value = data

            }
        }
    }
}