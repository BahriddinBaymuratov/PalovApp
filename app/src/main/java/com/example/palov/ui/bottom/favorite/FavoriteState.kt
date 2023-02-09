package com.example.palov.ui.bottom.favorite

import com.example.domain.model.Food

data class FavoriteState(
    val isLoading: Boolean = false,
    val foodList: List<Food> = emptyList()
)