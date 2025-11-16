package com.example.rick_mortyy.data.api

import retrofit2.http.GET

interface CartoonApi {
    @GET("character")
    suspend fun getCharacters(): List<String>
}