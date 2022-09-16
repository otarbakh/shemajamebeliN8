package com.example.shemajamebelin8.di.usecase

import com.bumptech.glide.load.engine.Resource
import com.example.shemajamebelin8.domain.SuitsRepository
import com.example.shemajamebelin8.models.SuitsResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class SuitsUseCase @Inject constructor(
    private val repository: SuitsRepository
){
    operator fun invoke(): Flow<Resource<List<SuitsResponse>>> = flow {
        try {
            emit(Resource.Loading(true))
            val teams = repository.getShmotkebiAnswer()
            emit(Resource.Success(teams))
        }
        catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage ?: "Unexpected"))
        }
        catch (e: IOException){
            emit(Resource.Error("couldn't reach server"))
        }
    }
}