package com.dedenko.ui.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.dedenko.R
import com.dedenko.ui.viewmodel.DataStorageViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ContainerActivity : AppCompatActivity() {

    //initialize data storage viewModel
    private val dataStorageViewModel: DataStorageViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_container)

        //If the user made it to this activity, set value to true
        dataStorageViewModel.setHasSeenIntro(true)

    }
}