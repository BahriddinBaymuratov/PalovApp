package com.example.domain.use_case.remote.local.room

import com.example.domain.repository.LocalRepository
import com.example.domain.use_case.base.BaseUseCase
import javax.inject.Inject

typealias DeleteFavoriteFoodBaseUseCase = BaseUseCase<Int, Unit>

class DeleteFavoriteFoodUseCase @Inject constructor(
    private val repository: LocalRepository
): DeleteFavoriteFoodBaseUseCase {
    override suspend fun invoke(parameter: Int) {
        repository.deleteFood(parameter)
    }
}