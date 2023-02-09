package com.example.domain.use_case.base

import com.example.domain.use_case.remote.GetAllRecipesUseCase
import com.example.domain.use_case.remote.local.data_store.*
import com.example.domain.use_case.remote.local.room.*

data class AllUseCases(
    val getAllRecipesUseCase: GetAllRecipesUseCase,
    val getFoodTypeUseCase: GetFoodTypeUseCase,
    val saveFoodTypeUseCase: SaveFoodTypeUseCase,
    val deleteFavoriteFoodUseCase: DeleteFavoriteFoodUseCase,
    val getFavoriteFoodByIdUseCase: GetFavoriteFoodByIdUseCase,
    val getFavoriteFoodsUseCase: GetFavoriteFoodsUseCase,
    val saveFavoriteFoodUseCase: SaveFavoriteFoodUseCase,
    val deleteAllFavoriteFoodsUseCase: DeleteAllFavoriteFoodsUseCase,
    val saveThemeUseCase: SaveThemeUseCase,
    val getThemeUseCase: GetThemeUseCase,
    val saveUserVisitingUseCase: SaveUserVisitingUseCase,
    val getUserVisitingUseCase: GetUserVisitingUseCase
)