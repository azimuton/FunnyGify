package com.azimuton.data

import com.azimuton.data.models.DataEntity

interface GifDataSource {
    fun getGifTrends(): List<DataEntity>
}