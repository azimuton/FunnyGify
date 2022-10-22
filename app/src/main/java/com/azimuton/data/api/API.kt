package com.azimuton.data.api

import com.azimuton.data.models.Gify
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface API {

    @GET("v1/gifs/trending?api_key=6QzOLhb1jKvX63O2SCg30RyCZwTu9TjJ&limit=25&rating=g")
    fun getGifs() : Call<Gify>

//    @GET("v1/gifs/trending?api_key=6QzOLhb1jKvX63O2SCg30RyCZwTu9TjJ&limit=25&rating=g")
//    fun getDetails() : Call<Data>

    companion object {

        var BASE_URL = "https://api.giphy.com/"

        fun create() : API {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(API::class.java)

        }
    }
}
