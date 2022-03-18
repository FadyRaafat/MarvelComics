package com.fady.marvelcomics.api.factory.comics

import androidx.lifecycle.MutableLiveData
import com.fady.marvelcomics.repository.NetworkRepository
import com.fady.marvelcomics.ui.utils.LoadingState
import com.fady.marvelcomics.ui.utils.NetworkState
import com.fady.marvelcomics.ui.utils.SingleLiveEvent
import androidx.paging.DataSource
import com.fady.marvelcomics.api.models.CharactersResponse

class CharactersDataSourceFactory(
    private val networkRepository: NetworkRepository,
    private val networkStatusMutableLiveData: SingleLiveEvent<NetworkState>,
    val loadingState: LoadingState,
    val offset: Int
) : DataSource.Factory<Int, CharactersResponse.Data.Result>() {

    val sourceLiveData = MutableLiveData<CharactersDataSource>()
    override fun create(): DataSource<Int, CharactersResponse.Data.Result> {
        val source = CharactersDataSource(
            networkRepository,
            networkStatusMutableLiveData,
            loadingState,
            offset
        )
        sourceLiveData.postValue(source)
        return source
    }
}