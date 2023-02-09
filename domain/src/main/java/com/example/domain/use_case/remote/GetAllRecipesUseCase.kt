package com.example.domain.use_case.remote

import com.example.domain.model.Food
import com.example.domain.repository.RemoteRepository
import com.example.domain.use_case.base.BaseUseCase
import com.example.domain.util.ResponseL
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

typealias GetAllRecipesBaseUseCase = BaseUseCase<Map<String, String>, Flow<ResponseL<List<Food>>>>

class GetAllRecipesUseCase @Inject constructor(
    private val repository: RemoteRepository
) : GetAllRecipesBaseUseCase{
    override suspend fun invoke(parameter: Map<String, String>): Flow<ResponseL<List<Food>>> {
        return repository.getAllRecipes(parameter)
    }
}