package com.example.harrypotter.api

import com.example.harrypotter.models.HPCharacterItem
import retrofit2.Response
import retrofit2.http.GET

interface CharacterAPI {

    @GET("api/characters")
    suspend fun getCharacterList() : Response<List<HPCharacterItem>>

}