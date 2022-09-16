package com.example.shemajamebelin8.domain

import com.example.shemajamebelin8.models.ShmotkebiResponse


interface ShmotkebiRepository {

    suspend fun getShmotkebiAnswer(): List<ShmotkebiResponse>

}