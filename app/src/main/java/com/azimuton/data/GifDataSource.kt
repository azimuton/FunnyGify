package com.azimuton.data

import com.azimuton.data.models.DataEntity

interface GifDataSource {
  suspend fun getGifTrends(): List<DataEntity>
}