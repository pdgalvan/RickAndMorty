package com.example.rickandmorty.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.rickandmorty.data.local.model.CharacterDataBaseModel

@Database(entities = [CharacterDataBaseModel::class],
          version = 1)
abstract class RickAndMortyDatabase : RoomDatabase(){
    abstract fun characterDao() : CharacterDao
}