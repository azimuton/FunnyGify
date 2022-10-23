package com.azimuton.data.repository

import com.azimuton.data.GifDataSource
import com.azimuton.data.mapper.ListDataMapper
import com.azimuton.domain.model.Data
import com.azimuton.domain.repository.GifRepository

class GifRepositoryImpl(private val gifStorage : GifDataSource) : GifRepository {
    override suspend fun getGifs(): List<Data> {
        return ListDataMapper().mapFromEntity(gifStorage.getGifTrends())
    }
}