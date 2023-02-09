package com.example.domain.use_case.remote.local.room

import com.example.domain.model.Food
import com.example.domain.repository.LocalRepository
import com.example.domain.use_case.base.BaseUseCase
import javax.inject.Inject

typealias SaveFavoriteFoodBaseUseCase = BaseUseCase<Food, Unit>

class SaveFavoriteFoodUseCase @Inject constructor(
    private val repository: LocalRepository
): SaveFavoriteFoodBaseUseCase {
    override suspend fun invoke(parameter: Food) {
        repository.saveFavoriteFood(parameter)
    }
}