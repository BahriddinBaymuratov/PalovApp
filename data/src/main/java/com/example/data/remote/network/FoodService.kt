package com.example.data.remote.network

import com.example.data.remote.model.FoodResponseDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface FoodService {
    @GET("recipes/complexSearch")
    suspend fun getAllRecipes(
        @QueryMap map: Map<String, String>
    ): Response<FoodResponseDTO>
}