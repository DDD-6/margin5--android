package com.margin.wine.di

import com.margin.wine.data.source.repository.WineRepositoryImpl
import com.margin.wine.domain.repository.WineRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
internal abstract class DataModule {

    @Binds
    abstract fun bindWineRepository(
        repository: WineRepositoryImpl
    ) : WineRepository
}