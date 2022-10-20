package com.azimuton.data.api

import com.azimuton.data.models.Data
import com.azimuton.data.models.Gify
import retrofit2.Call
import retrofit2.http.GET

interface API {

    @GET("v1/gifs/trending?api_key=6QzOLhb1jKvX63O2SCg30RyCZwTu9TjJ&limit=25&rating=g")
    fun getRandomIdea() : Call<Gify>
}
