package com.azimuton.domain.repository

import com.azimuton.domain.model.Data

interface GifRepository {
    suspend fun getGifs() : List<Data>
}