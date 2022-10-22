package com.azimuton.funnygify.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import com.azimuton.funnygify.R
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_big_gify.*


class BigGifyFragment : Fragment() {

    //lateinit var gifyEntityList: ArrayList<DataEntity>
    //lateinit var result : String


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_big_gify, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        Glide.with(requireContext())
            .asGif()
            .load(R.drawable.giphy)
            .into(ivBackBigGif)

        ivBackBigGif.setOnClickListener {
           // val controller = findNavController()
            //MAIN.navController.navigate(R.id.action_bigGifyFragment_to_listGifyFragment2)
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(R.id.fragmentContainerView, ListGifyFragment())
                ?.commit()
        }

//        activity?.supportFragmentManager?.setFragmentResultListener("id", requireActivity()) { key, bundle ->
//            // Здесь можно передать любой тип, поддерживаемый Bundle-ом
//             result = bundle.getString("data").toString()
//        }
//        Log.d("tt", result)

            val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                activity?.supportFragmentManager
                    ?.beginTransaction()
                    ?.replace(R.id.fragmentContainerView, ListGifyFragment())
                    ?.commit()
            }
        }
        activity?.onBackPressedDispatcher?.addCallback(viewLifecycleOwner, callback)
    }
    }


