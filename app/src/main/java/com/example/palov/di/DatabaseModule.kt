package com.example.palov.di

import android.content.Context
import androidx.room.Room
import com.example.data.local.database.FoodDao
import com.example.data.local.database.FoodDatabase
import com.example.data.local.manager.DataStoreManager
import com.example.data.repository.LocalRepositoryImpl
import com.example.domain.repository.LocalRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @[Provides Singleton]
    fun provideDataStoreManager(@ApplicationContext context: Context): DataStoreManager {
        return DataStoreManager(context)
    }
    @[Provides Singleton]
    fun provideLocalRepository(manager: DataStoreManager,dao: FoodDao): LocalRepository {
        return LocalRepositoryImpl(manager, dao)
    }

    @[Provides Singleton]
    fun provideFoodDatabase(
        @ApplicationContext context: Context
    ): FoodDatabase {
        return Room.databaseBuilder(
            context,
            FoodDatabase::class.java,
            "Food.db"
        ).build()
    }
    @[Provides Singleton]
    fun providesFoodDao(database: FoodDatabase): FoodDao {
        return database.dao
    }
}