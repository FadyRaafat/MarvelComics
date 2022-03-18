package com.fady.marvelcomics.viewmodels

import android.app.Application
import androidx.lifecycle.Observer
import com.fady.marvelcomics.api.models.ComicsResponse
import com.fady.marvelcomics.api.models.SeriesResponse
import com.fady.marvelcomics.ui.utils.JsonUtils
import com.google.gson.Gson
import junit.framework.TestCase
import org.junit.Before
import org.mockito.Mockito

class MainViewModelTest : TestCase() {


    var mainViewModel: MainViewModel? = null

    @Before
    fun setup() {
        val appllication = Mockito.mock(Application::class.java)
        mainViewModel = MainViewModel(appllication)

    }

    fun testSetComicsMutableLivedata() {
        mainViewModel?.let {
            val jsonResponse =
                JsonUtils().getJson(javaClass.classLoader, "200_comics_response")
            val charactersResponse = Gson().fromJson(jsonResponse, ComicsResponse::class.java)

            val observer = Observer<ComicsResponse> { response ->
                assert(response.code == 200)
                assert(!response.data?.results.isNullOrEmpty())
            }

            mainViewModel!!.comicMutableLiveData.observeForever(observer)
            mainViewModel!!.comicMutableLiveData.postValue(charactersResponse)
            mainViewModel!!.comicMutableLiveData.removeObserver(observer)
        }
    }

    fun testGetSeriesMutableLiveData() {
        mainViewModel?.let {
            val jsonResponse =
                JsonUtils().getJson(javaClass.classLoader, "200_comics_response")
            val seriesResponse = Gson().fromJson(jsonResponse, SeriesResponse::class.java)

            val observer = Observer<SeriesResponse> { response ->
                assert(response.code == 200)
                assert(!response.data?.results.isNullOrEmpty())
            }

            mainViewModel!!.seriesMutableLiveData.observeForever(observer)
            mainViewModel!!.seriesMutableLiveData.postValue(seriesResponse)
            mainViewModel!!.seriesMutableLiveData.removeObserver(observer)
        }

    }

}