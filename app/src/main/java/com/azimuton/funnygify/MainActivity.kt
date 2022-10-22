package com.azimuton.funnygify

import android.os.Bundle
import android.view.View
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import com.azimuton.funnygify.fragments.SplashGifyFragment

class MainActivity : AppCompatActivity() {
    //lateinit var navController : NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val  w : Window = window
        w.decorView.setSystemUiVisibility(
            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // скрываем нижнюю панель навигации
                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY) //появляется поверх активити и исчезает
        setContentView(R.layout.activity_main)

        //MAIN = this
        //navController = Navigation.findNavController(this, R.id.fragmentContainerView)
        //MAIN.navController.navigate(R.id.splashGifyFragment)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainerView, SplashGifyFragment())
            .commit()
    }
}