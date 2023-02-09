package com.example.domain.repository

import kotlinx.coroutines.flow.Flow
import com.example.domain.model.Food
import com.example.domain.model.FoodType

interface LocalRepository {
    suspend fun saveFoodType(foodType: FoodType)
    fun getFoodType(): Flow<FoodType>
    suspend fun saveTheme(index: Int)
    fun getTheme(): Flow<Int>
    suspend fun saveUserVisiting(boolean: Boolean)
    fun getUserVisiting(): Flow<Boolean>

    suspend fun saveFavoriteFood(food: Food)
    fun getFoodById(id: Int): Flow<Food?>
    fun getFoodList(): Flow<List<Food>>
    suspend fun deleteFood(foodId: Int)
    suspend fun deleteAllFavoriteFoods()
}