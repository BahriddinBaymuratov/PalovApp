package com.example.domain.use_case.remote.local.data_store

import com.example.domain.model.FoodType
import com.example.domain.repository.LocalRepository
import com.example.domain.use_case.base.BaseUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

typealias GetFoodTypeBaseUseCase = BaseUseCase<Unit,Flow<FoodType>>

class GetFoodTypeUseCase @Inject constructor(
    private val repository: LocalRepository
): GetFoodTypeBaseUseCase {
    override suspend fun invoke(parameter: Unit): Flow<FoodType> {
        return repository.getFoodType()
    }
}