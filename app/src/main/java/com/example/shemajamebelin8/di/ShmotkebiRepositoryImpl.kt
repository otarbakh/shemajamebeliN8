package com.example.shemajamebelin8.di

import com.example.shemajamebelin8.domain.ShmotkebiRepository
import com.example.shemajamebelin8.models.ShmotkebiResponse
import com.example.shemajamebelin8.network.ShmotkebiApi
import javax.inject.Inject

class ShmotkebiRepositoryImpl @Inject constructor(
    private val shmotkebiApi: ShmotkebiApi
): ShmotkebiRepository {

    override suspend fun getShmotkebiAnswer(): List<ShmotkebiResponse> {
        return shmotkebiApi.getShmotkebiService()
    }
}