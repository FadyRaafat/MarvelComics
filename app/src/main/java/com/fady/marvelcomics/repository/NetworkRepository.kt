package com.fady.marvelcomics.repository

import android.content.Context
import com.fady.marvelcomics.api.models.CharactersResponse
import com.fady.marvelcomics.api.models.ComicsResponse
import com.fady.marvelcomics.api.models.SeriesResponse
import com.fady.marvelcomics.api.services.ClientService
import io.reactivex.Observable
import retrofit2.Call

class NetworkRepository constructor(context: Context) {
    var clientService = ClientService.getClient(context)


    fun getCharacters(
        offset: Int
    ): Call<CharactersResponse> {
        return clientService.characters(
            offset
        )
    }

    fun getComics(
        characterId: String
    ): Observable<ComicsResponse> {
        return clientService.getCharacterComics(
            characterId
        )
    }

    fun getSeries(
        characterId: String
    ): Observable<SeriesResponse> {
        return clientService.getCharacterSeries(
            characterId
        )
    }

}