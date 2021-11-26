package com.margin.wine.di

import android.content.Context
import androidx.room.Room
import com.margin.wine.data.source.local.WineLocalDataSource
import com.margin.wine.data.source.local.WineNoteLocalDataSource
import com.margin.wine.local.datasource.WineLocalDataSourceImpl
import com.margin.wine.local.datasource.WineNoteLocalDataSourceImpl
import com.margin.wine.local.room.AppDataBase
import com.margin.wine.local.room.DATABASE_NAME
import com.margin.wine.local.room.dao.WineDao
import com.margin.wine.local.room.dao.WineNoteDao
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class LocalModule {

    @Binds
    abstract fun bindWineLocalDataSource(
        source: WineLocalDataSourceImpl
    ): WineLocalDataSource

    @Binds
    abstract fun bindWineNoteLocalDataSource(
        source: WineNoteLocalDataSourceImpl
    ): WineNoteLocalDataSource


    @InstallIn(SingletonComponent::class)
    @Module
    internal object LocalProvideModule {

        @Provides
        fun provideWineDao(db: AppDataBase): WineDao = db.wineDao()

        @Provides
        fun provideWineNoteDao(db: AppDataBase): WineNoteDao = db.wineNoteDao()

        @Provides
        fun provideAppDataBase(@ApplicationContext context: Context) =
            Room.databaseBuilder(context, AppDataBase::class.java, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build()
    }
}