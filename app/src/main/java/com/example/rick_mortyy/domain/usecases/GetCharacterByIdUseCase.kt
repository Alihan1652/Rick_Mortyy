package com.example.rick_mortyy.domain.usecases

import com.example.rick_mortyy.core.Either
import com.example.rick_mortyy.domain.models.Character
import com.example.rick_mortyy.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow

class GetCharacterByIdUseCase(
    private val repository: CharacterRepository
) {
    operator fun invoke(id: Int): Flow<Either<String, Character>> =
        repository.getCharacterByID(id)
}
