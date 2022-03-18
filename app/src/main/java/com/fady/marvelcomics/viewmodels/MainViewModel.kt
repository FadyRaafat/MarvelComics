package com.fady.marvelcomics.viewmodels

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.fady.marvelcomics.R
import com.fady.marvelcomics.api.factory.comics.CharactersDataSourceFactory
import com.fady.marvelcomics.api.models.CharactersResponse
import com.fady.marvelcomics.api.models.ComicsResponse
import com.fady.marvelcomics.api.models.SeriesResponse
import com.fady.marvelcomics.repository.NetworkRepository
import com.fady.marvelcomics.ui.utils.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

@SuppressLint("CheckResult")
class MainViewModel(application: Application) :
    AndroidViewModel(application) {
    var backCLickEvent = SingleLiveEvent<Void>()
    var networkRepository = NetworkRepository(application.applicationContext)
    var appExecutors = AppExecutors()
    var networkStatusMutableLiveData = SingleLiveEvent<NetworkState>()
    var toolbarData = ToolbarData()
    fun backClick() {
        backCLickEvent.call()
    }


    var charactersLoadingState: LoadingState = LoadingState()
    var offsetMutable = MutableLiveData<Int>()
    var charactersLiveData =
        Transformations.switchMap<Int, PagedList<CharactersResponse.Data.Result>>(
            offsetMutable
        ) {
            if (it != null) {
                val dataSourceFactory = CharactersDataSourceFactory(
                    networkRepository,
                    networkStatusMutableLiveData,
                    charactersLoadingState,
                    it
                )
                val config = PagedList.Config.Builder()
                    .setPageSize(5)
                    .build()
                LivePagedListBuilder(dataSourceFactory, config)
                    .setInitialLoadKey(null)
                    .setBoundaryCallback(null)
                    .setFetchExecutor(appExecutors.networkIO())
                    .build()
            } else {
                AbsentLiveData.create()
            }
        }

    fun retryCharacters() {
        charactersLoadingState.setRetry { retryCharacters() }
        charactersLoadingState.loadingState()
        offsetMutable.value = 0
    }


    // Comics
    var comicsLoadingState: LoadingState = LoadingState()
    val comicMutableLiveData = MutableLiveData<ComicsResponse>()
    fun getComics(
        context: Context,
        characterId: String,
        onFinish: (Boolean, String?) -> Unit
    ) {
        comicsLoadingState.setRetry { getComics(context, characterId, onFinish) }
        comicsLoadingState.loadingState()
        networkRepository.getComics(characterId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())?.subscribe(
                { it ->
                    if (it.code == 200) {
                        onFinish.invoke(true, null)
                        comicMutableLiveData.value = it

                    }
                },
                {
                    if (InternetCheckUtils.getConnectionType(context) == 0) {
                        onFinish.invoke(
                            false,
                            context.resources.getString(R.string.check_connection_try_again)
                        )
                    } else {
                        onFinish.invoke(false, it.message)

                    }
                }
            )
    }


    // Series
    var seriesLoadingState: LoadingState = LoadingState()
    val seriesMutableLiveData = MutableLiveData<SeriesResponse>()
    fun getSeries(
        context: Context,
        characterId: String,
        onFinish: (Boolean, String?) -> Unit
    ) {
        seriesLoadingState.setRetry { getSeries(context, characterId, onFinish) }
        seriesLoadingState.loadingState()
        networkRepository.getSeries(characterId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())?.subscribe(
                { it ->
                    if (it.code == 200) {
                        onFinish.invoke(true, null)
                        seriesMutableLiveData.value = it

                    }
                },
                {
                    if (InternetCheckUtils.getConnectionType(context) == 0) {
                        onFinish.invoke(
                            false,
                            context.resources.getString(R.string.check_connection_try_again)
                        )
                    } else {
                        onFinish.invoke(false, it.message)

                    }
                }
            )
    }



}