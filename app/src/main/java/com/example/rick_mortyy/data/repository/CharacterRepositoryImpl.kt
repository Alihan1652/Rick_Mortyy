package com.example.rick_mortyy.data.repository

import com.example.rick_mortyy.core.Either
import com.example.rick_mortyy.data.api.CartoonApi
import com.example.rick_mortyy.data.base.BaseRepository
import com.example.rick_mortyy.data.mapper.toDomain
import com.example.rick_mortyy.domain.models.Character
import com.example.rick_mortyy.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow

class CharacterRepositoryImpl(
    private val api: CartoonApi
) : CharacterRepository, BaseRepository() {

    override fun getCharacters(): Flow<Either<String, List<Character>>> {
        return doRequest2 {
            api.getCharacters().characters.toDomain()
        }
    }

    override fun getCharacterByID(id: Int): Flow<Either<String, Character>> {
        return doRequest2 {
            api.getCharacterByID(id).toDomain()
        }
    }
}
