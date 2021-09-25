package com.example.rickandmorty.data.repository

import android.util.Log
import com.example.rickandmorty.data.local.CharacterDao
import com.example.rickandmorty.data.remote.RickAndMortyApi
import com.example.rickandmorty.data.remote.model.CharacterResponse
import com.example.rickandmorty.data.remote.model.toCharacterDBModel
import com.example.rickandmorty.domain.repository.RickAndMortyRepository


import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class RickAndMortyRepositoryImpl @Inject constructor(
    private val api : RickAndMortyApi,
    private val dao : CharacterDao
) : RickAndMortyRepository{
    override fun getCharacterById(characterId: Int): Single<CharacterResponse> {

        return Single.create {
            api.getCharacterById(characterId)
                .subscribeOn(Schedulers.io())
                .subscribe({ characterResponse ->
                    dao.insertCharacter(characterResponse.toCharacterDBModel())
                },{
                    Log.d("TAG","Error on connection")
                })

        }
    }

}