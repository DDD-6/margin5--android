package com.margin.wine.di

import com.margin.wine.data.source.local.WineLocalDataSource
import com.margin.wine.local.datasource.WineLocalDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class LocalModule {

    @Binds
    abstract fun bindWineLocalDataSource(
        source: WineLocalDataSourceImpl
    ) : WineLocalDataSource
}