package com.example.shemajamebelin8.di

import com.example.shemajamebelin8.domain.SuitsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindSuits(
        suitsRepository:SuitsRepositoryImpl
    ): SuitsRepository
}