package com.fady.marvelcomics.api.factory.comics

import androidx.paging.PageKeyedDataSource
import com.fady.marvelcomics.api.models.CharactersResponse
import com.fady.marvelcomics.repository.NetworkRepository
import com.fady.marvelcomics.ui.utils.LoadingState
import com.fady.marvelcomics.ui.utils.NetworkState
import com.fady.marvelcomics.ui.utils.SingleLiveEvent
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CharactersDataSource(
    private val networkRepository: NetworkRepository,
    private val networkStatusMutableLiveData: SingleLiveEvent<NetworkState>,
    val loadingState: LoadingState,
    val offset: Int

) : PageKeyedDataSource<Int, CharactersResponse.Data.Result>() {
    private var retry: (() -> Any)? = null

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, CharactersResponse.Data.Result>
    ) {
        networkStatusMutableLiveData.postValue(NetworkState.INIT_LOADING)
        try {
            val request = networkRepository.getCharacters(offset)
            val response = request.execute()
            val items = response.body()?.data?.results
            items?.let { callback.onResult(it, null, 20) }
            retry = null
            networkStatusMutableLiveData.postValue(NetworkState.LOADED)
            if (response.isSuccessful)
                loadingState.loadedState()
            else
                loadingState.errorState("Couldn't find a result matches your search")


        } catch (ioException: Exception) {
            loadingState.errorState("Check internet and try again")
        }
    }

    override fun loadAfter(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, CharactersResponse.Data.Result>
    ) {
        networkStatusMutableLiveData.postValue(NetworkState.LOADING)
        networkRepository.getCharacters(
            params.key
        ).enqueue(object : Callback<CharactersResponse> {

            override fun onResponse(
                call: Call<CharactersResponse>,
                response: Response<CharactersResponse>
            ) {
                if (response.isSuccessful) {
                    networkStatusMutableLiveData.postValue(NetworkState.LOADED)
                    val items = response.body()?.data?.results
                    items?.let { callback.onResult(it, null) }
                    loadingState.loadedState()
                    retry = null
                }
            }

            override fun onFailure(call: Call<CharactersResponse>, t: Throwable) {
                loadingState.errorState("Check internet and try again")
            }
        })
    }

    override fun loadBefore(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, CharactersResponse.Data.Result>
    ) {
    }
}
