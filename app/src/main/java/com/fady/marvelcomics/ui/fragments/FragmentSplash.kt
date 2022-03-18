package com.fady.marvelcomics.ui.fragments

import android.annotation.SuppressLint
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.fady.marvelcomics.R
import com.fady.marvelcomics.databinding.FragmentSplashBinding
import com.fady.marvelcomics.ui.common.BaseFragment
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class FragmentSplash : BaseFragment<FragmentSplashBinding>() {

    override fun layout(): Int = R.layout.fragment_splash

    @SuppressLint("CheckResult")
    override fun onActivityCreated() {
        mainViewModel.toolbarData.handleSplash()
        viewLifecycleOwner.lifecycleScope.launch {
            delay(1500L)
            findNavController().navigate(FragmentSplashDirections.actionFragmentSplashToFragmentHome())

        }

    }
}