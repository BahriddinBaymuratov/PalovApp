package com.example.palov.di

import android.content.Context
import com.example.data.remote.network.FoodService
import com.example.data.repository.RemoteRepositoryImpl
import com.example.data.util.Constants
import com.example.domain.repository.LocalRepository
import com.example.domain.repository.RemoteRepository
import com.example.domain.use_case.base.AllUseCases
import com.example.domain.use_case.remote.GetAllRecipesUseCase
import com.example.domain.use_case.remote.local.data_store.*
import com.example.domain.use_case.remote.local.room.*
import com.example.palov.util.NetworkHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module()
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @[Provides Singleton]
    fun provideOkhttp(): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()
    }

    @[Provides Singleton]
    fun provideFoodService(
        okHttpClient: OkHttpClient
    ): FoodService {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(FoodService::class.java)
    }

    @[Provides Singleton]
    fun provideRemoteRepository(service: FoodService): RemoteRepository {
        return RemoteRepositoryImpl(service)
    }

    @[Provides Singleton]
    fun provideAllUseCases(
        remoteRepository: RemoteRepository,
        localRepository: LocalRepository
    ): AllUseCases {
        return AllUseCases(
            getAllRecipesUseCase = GetAllRecipesUseCase(remoteRepository),
            saveFoodTypeUseCase = SaveFoodTypeUseCase(localRepository),
            getFoodTypeUseCase = GetFoodTypeUseCase(localRepository),
            getFavoriteFoodByIdUseCase = GetFavoriteFoodByIdUseCase(localRepository),
            getFavoriteFoodsUseCase = GetFavoriteFoodsUseCase(localRepository),
            saveFavoriteFoodUseCase = SaveFavoriteFoodUseCase(localRepository),
            deleteFavoriteFoodUseCase = DeleteFavoriteFoodUseCase(localRepository),
            deleteAllFavoriteFoodsUseCase = DeleteAllFavoriteFoodsUseCase(localRepository),
            saveThemeUseCase = SaveThemeUseCase(localRepository),
            getThemeUseCase = GetThemeUseCase(localRepository),
            getUserVisitingUseCase = GetUserVisitingUseCase(localRepository),
            saveUserVisitingUseCase = SaveUserVisitingUseCase(localRepository)
        )
    }

    @[Provides Singleton]
    fun provideNetworkHelper(@ApplicationContext context: Context): NetworkHelper {
        return NetworkHelper(context)
    }
}