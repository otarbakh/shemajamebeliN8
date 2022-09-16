package com.example.shemajamebelin8.di

import com.example.shemajamebelin8.domain.SuitsRepository
import com.example.shemajamebelin8.models.SuitsResponse
import com.example.shemajamebelin8.network.SuitsApi
import javax.inject.Inject

class SuitsRepositoryImpl @Inject constructor(
    private val suitsApi: SuitsApi
): SuitsRepository {

    override suspend fun getShmotkebiAnswer(): List<SuitsResponse> {
        return suitsApi.getSuitsService()
    }
}