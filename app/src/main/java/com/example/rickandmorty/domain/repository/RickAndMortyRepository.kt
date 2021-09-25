package com.example.rickandmorty.domain.repository

import com.example.rickandmorty.data.remote.model.CharacterResponse
import io.reactivex.Single

interface RickAndMortyRepository {

    //suspend fun getCharacters() : Response
    fun getCharacterById(characterId : Int) : Single<CharacterResponse>
}