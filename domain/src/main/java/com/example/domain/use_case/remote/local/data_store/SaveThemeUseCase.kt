package com.example.domain.use_case.remote.local.data_store

import com.example.domain.repository.LocalRepository
import com.example.domain.use_case.base.BaseUseCase
import javax.inject.Inject

typealias SaveThemeBaseUseCase = BaseUseCase<Int, Unit>

class SaveThemeUseCase @Inject constructor(
    private val repository: LocalRepository
): SaveThemeBaseUseCase {
    override suspend fun invoke(parameter: Int) {
        return repository.saveTheme(parameter)
    }
}