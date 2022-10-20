package com.azimuton.funnygify.fragments

import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import com.azimuton.funnygify.R
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_splash_gify.*
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext


class SplashGifyFragment : Fragment(), CoroutineScope {

    private val job = Job()

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash_gify, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        Glide.with(requireContext())
            .asGif()
            .load(R.drawable.tumblr)
            .into(ivSplash);

        CoroutineScope(Dispatchers.Main).launch {
            activity?.progressBar?.max = 1000
            val value = 1000
            ObjectAnimator.ofInt(progressBar, "progress", value).setDuration(3100).start()
            delay(3100)
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(R.id.flMain, ListGifyFragment())
                ?.commit()
            //NavController(requireContext()).graph.startDestination
//            startActivity(Intent(this@SplashGifyFragment, MainActivity :: class.java))
//            overridePendingTransition(0, R.anim.open_activity)
//            finish()
        }
//        async {
//            delay(3100)
//            go()
//        }
    }
//    fun go(){
//        activity?.supportFragmentManager
//            ?.beginTransaction()
//            ?.replace(R.layout.fl, ListGifyFragment())
//            ?.commit()
//    }
}