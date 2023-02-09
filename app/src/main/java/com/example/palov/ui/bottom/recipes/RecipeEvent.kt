package com.example.palov.ui.bottom.recipes

import com.example.domain.model.FoodType

sealed class RecipeEvent {
    data class GetAllRecipes(val foodType: FoodType): RecipeEvent()
    data class OnSearchFood(val query: String,): RecipeEvent()
    data class OnSaveFoodType(val foodType: FoodType): RecipeEvent()
    object OnApplyClicked: RecipeEvent()
}