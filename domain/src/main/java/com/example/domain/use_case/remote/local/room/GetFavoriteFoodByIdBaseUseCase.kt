package com.example.domain.use_case.remote.local.room

import com.example.domain.model.Food
import com.example.domain.repository.LocalRepository
import com.example.domain.use_case.base.BaseUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

typealias GetFavoriteFoodByIdBaseUseCase = BaseUseCase<Int, Flow<Food?>>

class GetFavoriteFoodByIdUseCase @Inject constructor(
    private val repository: LocalRepository
): GetFavoriteFoodByIdBaseUseCase {
    override suspend fun invoke(parameter: Int): Flow<Food?> {
        return repository.getFoodById(parameter)
    }
}