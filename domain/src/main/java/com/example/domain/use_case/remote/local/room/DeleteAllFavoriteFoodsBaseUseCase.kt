package com.example.domain.use_case.remote.local.room

import com.example.domain.repository.LocalRepository
import com.example.domain.use_case.base.BaseUseCase
import javax.inject.Inject

typealias DeleteAllFavoriteFoodsBaseUseCase = BaseUseCase<Unit, Unit>

class DeleteAllFavoriteFoodsUseCase @Inject constructor(
    private val repository: LocalRepository
) : DeleteAllFavoriteFoodsBaseUseCase {
    override suspend fun invoke(parameter: Unit) {
        repository.deleteAllFavoriteFoods()
    }
}