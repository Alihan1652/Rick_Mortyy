package com.example.rick_mortyy.domain.repository

import com.example.rick_mortyy.core.Either
import com.example.rick_mortyy.domain.models.Character
import kotlinx.coroutines.flow.Flow

interface CartoonRepository {
    fun getCharacters(): Flow<Either<String, List<Character>>>
}