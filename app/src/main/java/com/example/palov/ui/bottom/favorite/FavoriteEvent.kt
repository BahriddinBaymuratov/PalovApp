package com.example.palov.ui.bottom.favorite

sealed class FavoriteEvent {
    object OnDeleteAllFavoriteFoods: FavoriteEvent()
}