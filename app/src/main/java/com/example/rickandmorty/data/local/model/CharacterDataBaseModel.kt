package com.example.rickandmorty.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.rickandmorty.domain.model.Character

@Entity(tableName = "Character")
data class CharacterDataBaseModel(
    @PrimaryKey
    val id : Int,
    val name : String,
    val species : String,
    val status : String,
    val image : String
)

fun CharacterDataBaseModel.toCharacter() : Character{
    return Character(
        id = id,
        image = image,
        name = name,
        species = species,
        status = status
    )
}
