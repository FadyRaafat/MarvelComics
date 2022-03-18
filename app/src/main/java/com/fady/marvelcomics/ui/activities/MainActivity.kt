package com.fady.marvelcomics.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.fady.marvelcomics.R
import com.fady.marvelcomics.databinding.ActivityMainBinding
import com.fady.marvelcomics.viewmodels.MainViewModel

class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModels()
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.mainViewModel = mainViewModel
        mainViewModel.backCLickEvent.observeForever { navController().popBackStack() }
    }


    private fun navController(): NavController {
        return findNavController(R.id.nav_host_fragment)
    }



}