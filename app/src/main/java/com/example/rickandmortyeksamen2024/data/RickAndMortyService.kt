package com.example.rickandmortyeksamen2024.data

import okhttp3.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RickAndMortyService {
    @GET("character/{id}")
    suspend fun getCharacterById(
        @Path("id") id: Int
    ) : Response<Character>
}