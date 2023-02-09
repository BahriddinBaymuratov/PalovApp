package com.example.palov.ui.bottom.recipes

import com.example.domain.model.Food

data class RecipesState(
    val isLoading: Boolean = false,
    val error: String = "",
    val success: List<Food> = emptyList()
)