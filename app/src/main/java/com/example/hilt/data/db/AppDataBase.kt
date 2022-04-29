package com.example.hilt.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.hilt.data.db.dao.HiltDao
import com.example.hilt.data.entity.HiltEntity


@Database( entities = [HiltEntity::class], version = 1, exportSchema = false)
abstract class AppDataBase  :RoomDatabase(){

    abstract fun getHiltDao() : HiltDao

    companion object{
        const val APP_DATABASE_NAME = "HiltDataBase"
    }

}