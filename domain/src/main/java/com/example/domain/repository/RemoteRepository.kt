package com.example.domain.repository

import com.example.domain.model.Food
import com.example.domain.util.ResponseL
import kotlinx.coroutines.flow.Flow

interface RemoteRepository {
    suspend fun getAllRecipes(queryMap: Map<String, String>): Flow<ResponseL<List<Food>>>
}
