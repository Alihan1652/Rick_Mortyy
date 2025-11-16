package com.example.rick_mortyy.domain.repository

import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow

interface CartoonRepository {
    fun getCharacters(): Flow<List<String>>
}