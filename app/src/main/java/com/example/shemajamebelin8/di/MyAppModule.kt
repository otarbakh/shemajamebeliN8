package com.example.shemajamebelin8.di

import com.example.shemajamebelin8.const.Constants
import com.example.shemajamebelin8.network.ShmotkebiApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object MyAppModule {

    @Singleton
    @Provides
    fun provideShmotkebi(): ShmotkebiApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ShmotkebiApi::class.java)
    }
}