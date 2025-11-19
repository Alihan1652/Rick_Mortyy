package com.example.rick_mortyy.data.api

import com.example.rick_mortyy.data.models.BaseResponseDto
import retrofit2.http.GET

interface CartoonApi {
    @GET("character")
    suspend fun getCharacters(): retrofit2.Response<BaseResponseDto>
}