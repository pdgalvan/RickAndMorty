package com.example.rickandmorty.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.rickandmorty.data.local.model.CharacterDataBaseModel
import io.reactivex.Single

@Dao
interface CharacterDao {

    @Query("SELECT * FROM Character" +
            "WHERE Characters.id = :id")
    fun getCharacterById(id : Int?) : Single<CharacterDataBaseModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCharacter(character : CharacterDataBaseModel)
}