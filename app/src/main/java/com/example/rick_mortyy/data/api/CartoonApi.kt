package com.example.rick_mortyy.data.api

import com.example.rick_mortyy.data.models.BaseResponseDto
import com.example.rick_mortyy.data.models.CharacterDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CartoonApi {
    @GET("character")
    suspend fun getCharacters(): BaseResponseDto

    @GET("character/{id}")
    suspend fun getCharacterByID(@Path("id") id: Int): CharacterDto
}