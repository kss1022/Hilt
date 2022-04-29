package com.example.hilt.di

import com.example.hilt.data.repositorty.HiltRepository
import com.example.hilt.data.repositorty.HiltRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    @Singleton
    abstract fun provideHiltRepository(repository: HiltRepositoryImpl): HiltRepository
}