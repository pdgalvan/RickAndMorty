package com.example.rickandmorty.data.remote.model

data class Response(
    val info: Info,
    val results: List<CharacterResponse>
)