package com.fady.marvelcomics.ui.fragments

import androidx.navigation.fragment.findNavController
import androidx.paging.PagedList
import com.fady.marvelcomics.R
import com.fady.marvelcomics.api.models.CharactersResponse
import com.fady.marvelcomics.databinding.FragmentHomeBinding
import com.fady.marvelcomics.ui.adapters.CharactersPagingAdapter
import com.fady.marvelcomics.ui.common.BaseFragment

class FragmentHome : BaseFragment<FragmentHomeBinding>() {

    override fun layout(): Int = R.layout.fragment_home

    override fun onActivityCreated() {
        mainViewModel.toolbarData.handleHome()
        binding.mainViewModel = mainViewModel
        getHome()
    }

    private fun getHome() {
        mainViewModel.retryCharacters()
        mainViewModel.charactersLiveData.observe(
            viewLifecycleOwner
        ) { comics ->
            if (comics != null) {
                initComicsRecycler(comics)
            }
        }
    }

    private fun initComicsRecycler(comics: PagedList<CharactersResponse.Data.Result>) {
        val productsAdapter = CharactersPagingAdapter(
            this.requireContext(),
            mainViewModel.networkStatusMutableLiveData
        ) {
            findNavController().navigate(
                FragmentHomeDirections.actionFragmentHomeToFragmentCharacterDetails(
                    it
                )
            )
        }
        binding.comicsRecycler.adapter = productsAdapter
        productsAdapter.submitList(comics)


    }

}