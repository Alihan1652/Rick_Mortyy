package com.example.rick_mortyy.domain.usecases

import com.example.rick_mortyy.core.Either
import com.example.rick_mortyy.domain.models.Character
import com.example.rick_mortyy.domain.repository.CartoonRepository
import kotlinx.coroutines.flow.Flow

class GetCharacterUseCase(
    private val repository: CartoonRepository
) {
    fun getCharacters(): Flow<Either<String, List<Character>>> = repository.getCharacters()
}
