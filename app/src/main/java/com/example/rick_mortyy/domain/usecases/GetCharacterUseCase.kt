package com.example.rick_mortyy.domain.usecases

import com.example.rick_mortyy.domain.repository.CartoonRepository
import kotlinx.coroutines.flow.Flow

class GetCharacterUseCase(
    private val repository: CartoonRepository
) {
    fun getCharacters(): Flow<List<String>> = repository.getCharacters()
}

