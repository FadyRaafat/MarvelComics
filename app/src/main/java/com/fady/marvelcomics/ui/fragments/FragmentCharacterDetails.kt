package com.fady.marvelcomics.ui.fragments

import com.fady.marvelcomics.R
import com.fady.marvelcomics.api.models.ComicsResponse
import com.fady.marvelcomics.api.models.SeriesResponse
import com.fady.marvelcomics.databinding.FragmentCharacterDetailsBinding
import com.fady.marvelcomics.ui.adapters.ComicsAdapter
import com.fady.marvelcomics.ui.adapters.SeriesAdapter
import com.fady.marvelcomics.ui.common.BaseFragment

class FragmentCharacterDetails : BaseFragment<FragmentCharacterDetailsBinding>() {

    override fun layout(): Int = R.layout.fragment_character_details
    override fun onActivityCreated() {
        binding.mainViewModel = mainViewModel
        arguments?.let {
            if (!it.isEmpty) {
                val characterDetails = FragmentCharacterDetailsArgs.fromBundle(it).character
                characterDetails?.let {
                    binding.character = it
                    getComics(characterDetails.id.toString())
                    getSeries(characterDetails.id.toString())
                }
            }
        }
    }

    private fun getComics(characterId: String) {
        mainViewModel.getComics(requireContext(), characterId)
        { success, error ->
            mainViewModel.comicsLoadingState.loadedState()
            if (success) {
                initComicsObserver()
            }
        }

    }

    private fun initComicsObserver() {
        mainViewModel.comicMutableLiveData.observe(
            viewLifecycleOwner
        ) { comics ->
            if (comics != null) {
                initComicsRv(comics.data?.results)
            }
        }

    }

    private fun initComicsRv(comics: List<ComicsResponse.Data.Result?>?) {
        val adapter = ComicsAdapter()
        binding.comicsRV.adapter = adapter
        adapter.submitList(comics)

    }

    private fun getSeries(characterId: String) {
        mainViewModel.getSeries(requireContext(), characterId)
        { success, error ->
            mainViewModel.seriesLoadingState.loadedState()
            if (success) {
                initSeriesObserver()
            }
        }

    }

    private fun initSeriesObserver() {
        mainViewModel.seriesMutableLiveData.observe(
            viewLifecycleOwner
        ) { series ->
            if (series != null) {
                initSeriesRv(series.data?.results)
            }
        }

    }


    private fun initSeriesRv(series: List<SeriesResponse.Data.Result?>?) {
        val adapter = SeriesAdapter()
        binding.seriesRV.adapter = adapter
        adapter.submitList(series)

    }


}
