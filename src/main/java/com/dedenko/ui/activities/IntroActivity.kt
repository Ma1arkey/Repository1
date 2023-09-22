package com.dedenko.ui.activities


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import coil.load
import com.dedenko.R
import com.dedenko.databinding.ActivityIntroBinding
import com.dedenko.utils.Constants.IMAGE_URL
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class IntroActivity : AppCompatActivity() {

    //initialize binding variable
    private lateinit var binding: ActivityIntroBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //assign binding variable
        binding = ActivityIntroBinding.inflate(layoutInflater)

        //set content to view via binding
        setContentView(binding.root)

        //load my own code
        initView()

    }

    private fun initView(){

        //display epl image using coil
        binding.imageView.load(IMAGE_URL){
            placeholder(R.drawable.ic_launcher_logo)
        }

        //on click of any item in view
        handleClicks()

    }

    private fun handleClicks(){

        //on click button
        binding.btnEnter.setOnClickListener {

            //go to container activity
            val intent = Intent(this, ContainerActivity::class.java)
            startActivity(intent)

        }

    }

}