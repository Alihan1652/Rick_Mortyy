package com.example.rick_mortyy.data.repository

import com.example.rick_mortyy.core.Either
import com.example.rick_mortyy.data.api.CartoonApi
import com.example.rick_mortyy.data.mapper.toDomain
import com.example.rick_mortyy.domain.models.Character
import com.example.rick_mortyy.domain.repository.CartoonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.Dispatchers

class CartoonRepositoryImpl(
    private val api: CartoonApi
) : CartoonRepository {

    override fun getCharacters() : Flow<Either<String, List<Character>>> {
        return flow {
            try {
                val response = api.getCharacters()
                if (response.isSuccessful && response.body() != null){
                    response.body()?.let {result ->
                        emit(Either.Right(result.characters.toDomain()))
                    }
                } else{
                    emit(Either.Left(response.message()))
                }
            } catch (e: Exception) {
                emit(Either.Left (e.localizedMessage?: "Unknown error"))
            }
        }.flowOn(Dispatchers.IO)
    }
}