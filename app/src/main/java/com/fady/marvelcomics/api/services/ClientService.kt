package com.fady.marvelcomics.api.services

import android.content.Context
import com.fady.marvelcomics.api.LiveDataCallAdapterFactory
import com.fady.marvelcomics.api.models.CharactersResponse
import com.fady.marvelcomics.api.models.ComicsResponse
import com.fady.marvelcomics.api.models.SeriesResponse
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ClientService {

    companion object {
        fun getClient(context: Context): ClientService {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://gateway.marvel.com/v1/public/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(LiveDataCallAdapterFactory())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(HttpClient.getClient(context))
                .build()

            return retrofit.create(ClientService::class.java)
        }
    }

    @GET("characters")
    fun characters(
        @Query("offset") offset: Int,
        @Query("ts") ts: String = "1",
        @Query("hash") hash: String = "3142c121bd2923f4d971f4bc430032ed",
        @Query("apikey") apiKey: String = "3dbf30a522c0505df3b44a641fc946ed"
    ): Call<CharactersResponse>


    @GET("characters/{characterId}/comics")
    fun getCharacterComics(
        @Path("characterId") characterId: String,
        @Query("offset") offset: Int? = 0,
        @Query("limit") limit: Int? = 20,
        @Query("ts") ts: String = "1",
        @Query("hash") hash: String = "3142c121bd2923f4d971f4bc430032ed",
        @Query("apikey") apiKey: String = "3dbf30a522c0505df3b44a641fc946ed"

    ): Observable<ComicsResponse>

    @GET("characters/{characterId}/series")
    fun getCharacterSeries(
        @Path("characterId") characterId: String,
        @Query("offset") offset: Int? = 0,
        @Query("limit") limit: Int? = 20,
        @Query("ts") ts: String = "1",
        @Query("hash") hash: String = "3142c121bd2923f4d971f4bc430032ed",
        @Query("apikey") apiKey: String = "3dbf30a522c0505df3b44a641fc946ed"
    ): Observable<SeriesResponse>

}