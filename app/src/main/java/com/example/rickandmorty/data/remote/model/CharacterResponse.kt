package com.example.rickandmorty.data.remote.model

import com.example.rickandmorty.data.local.model.CharacterDataBaseModel

data class CharacterResponse(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: Location,
    val name: String,
    val origin: Origin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)

fun CharacterResponse.toCharacterDBModel() : CharacterDataBaseModel{
    return CharacterDataBaseModel(
        id = id,
        name = name,
        species=species,
        status=status,
        image=image
    )
}