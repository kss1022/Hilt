package com.example.hilt.data.repositorty

import com.example.hilt.data.db.dao.HiltDao
import com.example.hilt.data.entity.HiltEntity
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class HiltRepositoryImpl @Inject constructor(
    private val hiltDao: HiltDao,
    private val ioDispatcher : CoroutineDispatcher
) : HiltRepository {
    override suspend fun getEntityList(): List<HiltEntity> = withContext(ioDispatcher){
        hiltDao.getEntityList()
    }

    override suspend fun insertEntity(entity: HiltEntity)  = withContext(ioDispatcher){
        hiltDao.insert(entity)
    }
}