package com.example.rickandmorty.di


import android.content.Context
import androidx.room.Room
import com.example.rickandmorty.data.local.CharacterDao
import com.example.rickandmorty.data.local.RickAndMortyDatabase
import com.example.rickandmorty.data.remote.RickAndMortyApi
import com.example.rickandmorty.data.repository.RickAndMortyRepositoryImpl
import com.example.rickandmorty.domain.repository.RickAndMortyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRickAndMortyApi(): RickAndMortyApi {
        return Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RickAndMortyApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRickAndMortyRepository(api : RickAndMortyApi, dao: CharacterDao)
    : RickAndMortyRepository{

        return RickAndMortyRepositoryImpl(api,dao)
    }
    @Singleton
    @Provides
    fun provideRickAndMortyDataBase(
        @ApplicationContext app : Context) : RickAndMortyDatabase{
        return Room.databaseBuilder(
            app,
            RickAndMortyDatabase::class.java,
            "rnm_database"
        ).build()
    }
    @Singleton
    @Provides
    fun provideCharacterDao(db : RickAndMortyDatabase) : CharacterDao{
        return db.characterDao()
    }
}