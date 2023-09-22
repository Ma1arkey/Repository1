package com.dedenko.ui.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.blankj.utilcode.util.BarUtils
import com.blankj.utilcode.util.ScreenUtils
import com.dedenko.databinding.ActivitySplashScreenBinding
import com.dedenko.ui.viewmodel.DataStorageViewModel
import com.dedenko.utils.Constants.SPLASH_SCREEN_TIME
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity() {

    //initialize binding variable
    private lateinit var binding: ActivitySplashScreenBinding

    //initialize intent
    private var activityIntent: Intent? = null

    //initialize storage viewModel
    private val datStorageViewModel: DataStorageViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //assign binding
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)

        //utility transparent-status-bar function
        BarUtils.transparentStatusBar(this)

        //utility full screen function
        ScreenUtils.setFullScreen(this)

        //set view content
        setContentView(binding.root)

        //initializing codes
        initView()

    }

    private fun initView(){

        //check visit
        handlePersistence()

    }

    private fun handlePersistence(){

        //observe live data --> if user has seen intro
        datStorageViewModel.hasSeenIntro.observe(this){

            Log.e("vex", it.toString())

            //Go to intro or activity
            activityIntent = if (it){
                Intent(this, ContainerActivity::class.java)
            } else Intent(this, IntroActivity::class.java)
        }

        //bouncing ball
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(activityIntent)
            finish()}, SPLASH_SCREEN_TIME)

    }

}