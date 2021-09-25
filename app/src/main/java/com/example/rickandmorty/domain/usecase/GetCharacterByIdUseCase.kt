package com.example.rickandmorty.domain.usecase


import com.example.rickandmorty.domain.repository.RickAndMortyRepository
import javax.inject.Inject

class GetCharacterByIdUseCase @Inject constructor(
    private val repository: RickAndMortyRepository
){

}