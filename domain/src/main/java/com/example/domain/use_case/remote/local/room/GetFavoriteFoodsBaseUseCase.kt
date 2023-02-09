package com.example.domain.use_case.remote.local.room

import com.example.domain.model.Food
import com.example.domain.repository.LocalRepository
import com.example.domain.use_case.base.BaseUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

typealias GetFavoriteFoodsBaseUseCase = BaseUseCase<Unit, Flow<List<Food>>>

class GetFavoriteFoodsUseCase @Inject constructor(
    private val repository: LocalRepository
): GetFavoriteFoodsBaseUseCase {
    override suspend fun invoke(parameter: Unit): Flow<List<Food>> {
        return repository.getFoodList()
    }
}