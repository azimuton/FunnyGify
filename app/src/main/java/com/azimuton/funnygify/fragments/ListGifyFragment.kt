package com.azimuton.funnygify.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.azimuton.data.api.API
import com.azimuton.data.api.RetrofitClient
import com.azimuton.data.models.Gify
import com.azimuton.funnygify.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListGifyFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_gify, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val retrofit = RetrofitClient()
            .getClient("https://api.giphy.com/")
            .create(API::class.java)
        retrofit.getRandomIdea().enqueue(object : Callback<Gify> {
            override fun onResponse(call: Call<Gify>, response: Response<Gify>) {
//                btLoadNews.setOnClickListener {
//                    tvDescriptionNews.text =
//                        response.body()?.articles?.get(0)?.description.toString()
//                    tvTitleNews.text = response.body()?.articles?.get(0)?.title.toString()
//                    tvContentNews.text = response.body()?.articles?.get(0)?.content.toString()
//                    tvPublishedAt.text = response.body()?.articles?.get(0)?.publishedAt.toString()
//                    //ivImageNews.setImageURI(response.body()?.articles?.get(0)?.urlToImage?.toUri())
//                    Picasso.with(ivImageNews.context).load(response.body()?.articles?.get(0)?.urlToImage?.toUri()).into(ivImageNews)
//                }
            }

            override fun onFailure(call: Call<Gify>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}