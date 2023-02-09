package com.example.data.repository

import com.example.data.mapper.toFood
import com.example.data.remote.network.FoodService
import com.example.domain.model.Food
import com.example.domain.repository.RemoteRepository
import com.example.domain.util.ResponseL
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RemoteRepositoryImpl @Inject constructor(
    private val service: FoodService
) : RemoteRepository {
    override suspend fun getAllRecipes(queryMap: Map<String, String>): Flow<ResponseL<List<Food>>> =
        flow {
            emit(ResponseL.Loading)
            try {
                val response = service.getAllRecipes(queryMap)
                if (response.isSuccessful) {
                    response.body()?.results?.map { it.toFood() }?.let {
                        emit(ResponseL.Success(it))
                    }
                }
            } catch (e: Exception) {
                emit(ResponseL.Error(e.message.toString()))
            }
        }
}