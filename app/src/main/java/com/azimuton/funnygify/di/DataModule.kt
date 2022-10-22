package com.azimuton.funnygify.di

import com.azimuton.data.GifDataSource
import com.azimuton.data.api.API
import com.azimuton.data.api.GitDataSourceImpl
import com.azimuton.data.repository.GifRepositoryImpl
import com.azimuton.domain.repository.GifRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Singleton
    @Provides
    fun provideGifDataSource(api : API): GifDataSource {
        return GitDataSourceImpl(api = api)
    }
    @Provides
    @Singleton
    fun providesGifRepository(gifStorage : GifDataSource): GifRepository =
        GifRepositoryImpl(gifStorage = gifStorage)
}