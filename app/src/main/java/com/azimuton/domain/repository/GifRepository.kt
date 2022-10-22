package com.azimuton.domain.repository

import com.azimuton.domain.model.Data

interface GifRepository {
    fun getGifs() : List<Data>
}