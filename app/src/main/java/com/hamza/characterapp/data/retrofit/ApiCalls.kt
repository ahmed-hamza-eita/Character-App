package com.hamza.characterapp.data.retrofit

import com.hamza.characterapp.data.model.CharacterResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiCalls {

    @GET("character")
    fun getAllCharacters(): Call<CharacterResponse>

    @GET("character/{id}")
    fun getSingleCharacter(@Path("id") id: String): Call<CharacterResponse.Character>
}