package com.azimuton.domain.usecase

import com.azimuton.domain.model.Data
import com.azimuton.domain.repository.GifRepository

class GetGifsUseCase(private val gifRepository : GifRepository) {
      suspend fun execute() : List<Data>{
        return gifRepository.getGifs()
    }
}