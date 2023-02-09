package com.example.domain.use_case.remote.local.data_store

import com.example.domain.model.FoodType
import com.example.domain.repository.LocalRepository
import com.example.domain.use_case.base.BaseUseCase
import javax.inject.Inject

typealias SaveFoodTypeBaseUseCase = BaseUseCase<FoodType, Unit>

class SaveFoodTypeUseCase @Inject constructor(
    private val repository: LocalRepository
): SaveFoodTypeBaseUseCase {
    override suspend fun invoke(parameter: FoodType) {
        repository.saveFoodType(parameter)
    }
}