package com.margin.wine.di

import com.margin.wine.data.source.remote.WineRemoteDataSource
import com.margin.wine.remote.source.WineRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
internal abstract class RemoteModule {

    @Binds
    abstract fun bindWineRemoteDataSource(
        source: WineRemoteDataSourceImpl
    ) : WineRemoteDataSource
}