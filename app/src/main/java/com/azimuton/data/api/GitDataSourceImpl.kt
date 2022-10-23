package com.azimuton.data.api

import com.azimuton.data.GifDataSource
import com.azimuton.data.models.DataEntity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
class GitDataSourceImpl( private val api : API) : GifDataSource {
    //    override fun getGifTrends(): List<DataEntity> {
//        api.getGifs().enqueue(object : Callback<DataEntity>{
//            override fun onResponse(call: Call<DataEntity>, response: Response<DataEntity>) {
//                response.body()
//            }
//            override fun onFailure(call: Call<DataEntity>, t: Throwable) {
//
//            }
//
//        })
//        return listOf()
//    }
    override suspend fun getGifTrends(): List<DataEntity> {
        TODO("Not yet implemented")
    }
}