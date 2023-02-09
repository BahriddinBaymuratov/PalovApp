package com.example.domain.use_case.remote.local.data_store

import com.example.domain.repository.LocalRepository
import com.example.domain.use_case.base.BaseUseCase
import javax.inject.Inject

typealias SaveUserVisitingBaseUseCase = BaseUseCase<Boolean, Unit>

class SaveUserVisitingUseCase @Inject constructor(
    private val repository: LocalRepository
): SaveUserVisitingBaseUseCase {
    override suspend fun invoke(parameter: Boolean) {
        repository.saveUserVisiting(parameter)
    }
}