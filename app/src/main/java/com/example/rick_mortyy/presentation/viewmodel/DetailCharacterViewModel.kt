package com.example.rick_mortyy.presentation.viewmodel

import com.example.rick_mortyy.domain.models.Character
import com.example.rick_mortyy.domain.usecases.GetCharacterByIdUseCase
import com.example.rick_mortyy.presentation.base.BaseViewModel
import com.example.rick_mortyy.presentation.utils.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow


class DetailCharacterViewModel(
    private val getCharacterByIdUseCase: GetCharacterByIdUseCase
) : BaseViewModel() {

    private val _characterState = MutableStateFlow< UiState<Character>>(UiState.Empty)
    val characterState = _characterState.asStateFlow()

    fun getCharacterById(id: Int) {
            getCharacterByIdUseCase(id).handleFlowData(_characterState)
                }
        }