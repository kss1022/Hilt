package com.example.hilt.di

import android.content.Context
import androidx.room.Room
import com.example.hilt.data.db.AppDataBase
import com.example.hilt.data.db.dao.HiltDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Singleton
    @Provides
    fun provideIoDispatcher() = Dispatchers.IO

    @Singleton
    @Provides
    fun provideDataBase(@ApplicationContext context: Context): AppDataBase =
        Room.databaseBuilder(context, AppDataBase::class.java, AppDataBase.APP_DATABASE_NAME)
            .build()


    @Singleton
    @Provides
    fun provideHiltDao(db: AppDataBase): HiltDao = db.getHiltDao()
}