package com.example.palov.ui.detail.main

import com.example.domain.model.Food

sealed class DetailEvent {
    data class OnCheckFood(val id: Int): DetailEvent()
    data class OnUpdateFood(val food: Food): DetailEvent()
}