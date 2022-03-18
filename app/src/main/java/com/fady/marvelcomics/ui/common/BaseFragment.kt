package com.fady.marvelcomics.ui.common

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.fady.marvelcomics.viewmodels.MainViewModel
import com.fady.marvelcomics.ui.utils.AppExecutors

abstract class BaseFragment<V : ViewDataBinding> : Fragment() {

    lateinit var binding: V
    lateinit var toolbarBinding: ViewDataBinding
    val mainViewModel: MainViewModel by activityViewModels()

    lateinit var appExecutors: AppExecutors


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        appExecutors = AppExecutors()
        binding = DataBindingUtil.inflate(inflater, layout(), container, false)
        return binding.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        onActivityCreated()
    }

    abstract fun layout(): Int
    abstract fun onActivityCreated()
}