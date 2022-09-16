package com.example.shemajamebelin8.domain

import com.example.shemajamebelin8.models.SuitsResponse


interface SuitsRepository {

    suspend fun getShmotkebiAnswer(): List<SuitsResponse>

}