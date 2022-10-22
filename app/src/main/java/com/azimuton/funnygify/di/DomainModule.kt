package com.azimuton.funnygify.di

import com.azimuton.domain.repository.GifRepository
import com.azimuton.domain.usecase.GetGifsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    @Provides
    @Singleton
    fun providesGetGifsUseCase(gifRepository: GifRepository): GetGifsUseCase =
        GetGifsUseCase(gifRepository = gifRepository)
}