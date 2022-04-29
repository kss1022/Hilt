package com.example.hilt.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.hilt.data.entity.HiltEntity

@Dao
interface HiltDao {

    @Query("SELECT * FROM hiltentity")
    suspend fun getEntityList() : List<HiltEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert( entity: HiltEntity )
}