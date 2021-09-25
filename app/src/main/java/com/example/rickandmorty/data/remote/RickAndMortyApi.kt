package com.example.rickandmorty.data.remote


import com.example.rickandmorty.data.remote.model.CharacterResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface RickAndMortyApi {

    @GET("character/{characterId}")
    fun getCharacterById(@Path("characterId") characterId : Int) : Single<CharacterResponse>


}