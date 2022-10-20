package com.azimuton.funnygify.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.azimuton.data.api.API
import com.azimuton.data.api.RetrofitClient
import com.azimuton.data.models.Gify
import com.azimuton.funnygify.R
import com.azimuton.funnygify.adapters.ListGifyAdapter
import kotlinx.android.synthetic.main.fragment_list_gify.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListGifyFragment : Fragment() {
    lateinit var gifyList: ArrayList<Gify>

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
                gifyList = ArrayList<Gify>()
                val adapter = ListGifyAdapter(requireContext(), response.body()?.data)
                rvListGify.layoutManager = LinearLayoutManager(context)
                rvListGify.adapter = adapter
            }
            override fun onFailure(call: Call<Gify>, t: Throwable) {

            }
        })
    }
}