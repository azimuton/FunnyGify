package com.azimuton.funnygify.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.azimuton.data.api.API
import com.azimuton.data.api.RetrofitClient
import com.azimuton.data.models.DataEntity
import com.azimuton.data.models.GifyEntity
import com.azimuton.domain.model.Data
import com.azimuton.domain.model.Gify
import com.azimuton.funnygify.R
import com.azimuton.funnygify.adapters.ListGifyAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_list_gify.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
@AndroidEntryPoint
class ListGifyFragment : Fragment() {
    lateinit var gifyEntityList: ArrayList<Gify>
    //lateinit var dataList : ArrayList<Data>
    //lateinit var result : List<DataEntity>

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
        retrofit.getGifs().enqueue(object : Callback<Gify>, ListGifyAdapter.ItemClickListener {
            override fun onResponse(call: Call<Gify>, response: Response<Gify>) {
                gifyEntityList = ArrayList<Gify>()
                val adapter = ListGifyAdapter(requireContext(), response.body()!!.data, this)
                rvListGify.layoutManager = LinearLayoutManager(context)
                rvListGify.adapter = adapter
            }
            override fun onFailure(call: Call<Gify>, t: Throwable) {

            }

            override fun onItemClick(position: Int) {
                //MAIN.navController.navigate(R.id.action_listGifyFragment2_to_bigGifyFragment)
                activity?.supportFragmentManager
                    ?.beginTransaction()
                    ?.replace(R.id.fragmentContainerView, BigGifyFragment())
                    ?.commit()
//               val result = gifyEntityList.toList()
//                activity?.supportFragmentManager?.setFragmentResult("id", bundleOf("data" to result))
            }

            override fun details(index: Int, listGify: List<DataEntity>) {
//                val res = listGify[index].images
//                val text = listGify[index].title
//                activity?.supportFragmentManager?.setFragmentResult("id", bundleOf("data" to res))
//                activity?.supportFragmentManager?.setFragmentResult("id", bundleOf("data" to text))
            }
        })
    }
}