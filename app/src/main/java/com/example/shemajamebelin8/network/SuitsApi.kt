package com.example.shemajamebelin8.network

import com.example.shemajamebelin8.models.SuitsResponse
import retrofit2.http.GET

interface SuitsApi {
    @GET("05d71804-4628-4269-ac03-f86e9960a0bb")
    suspend fun getSuitsService(
    ) : List<SuitsResponse>
}