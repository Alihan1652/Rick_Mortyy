package com.example.rick_mortyy.data.base

import com.example.rick_mortyy.core.Either
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response

abstract class BaseRepository {

    protected fun <T> doRequest(
        request: suspend () -> Response<T>
    ): Flow<Either<String, T>> {
        return flow {
            delay(1000)
            try {
                val response = request()
                if (response.isSuccessful && response.body() != null) {
                    emit(Either.Right(response.body()!!))
                } else {
                    emit(Either.Left(response.message()))
                }
            } catch (e: Exception) {
                emit(Either.Left(e.localizedMessage ?: "Unknown error"))
            }
        }.flowOn(Dispatchers.IO)
    }

    protected fun <T> doRequest2(
        request: suspend () -> T
    ): Flow<Either<String, T>> {
        return flow {
            delay(300)
            try {
                val result = request()
                emit(Either.Right(result))
            } catch (e: Exception) {
                emit(Either.Left(e.localizedMessage ?: "Unknown error"))
            }
        }.flowOn(Dispatchers.IO)
    }
}
