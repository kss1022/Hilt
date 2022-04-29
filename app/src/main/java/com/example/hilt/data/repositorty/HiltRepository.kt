package com.example.hilt.data.repositorty

import com.example.hilt.data.entity.HiltEntity

interface HiltRepository {

    suspend fun getEntityList(): List<HiltEntity>

    suspend fun  insertEntity( entity: HiltEntity)
}