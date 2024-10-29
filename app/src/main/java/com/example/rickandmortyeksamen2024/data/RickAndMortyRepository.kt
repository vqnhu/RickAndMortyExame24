package com.example.rickandmortyeksamen2024.data

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RickAndMortyRepository {
    private val _okHttpClient = OkHttpClient.Builder()
        .addInterceptor(
            HttpLoggingInterceptor().setLevel(
                HttpLoggingInterceptor.Level.BODY
            )
        ).build()

    private val _retrofit = Retrofit.Builder()
        .client(_okHttpClient)
        .baseUrl("https://rickandmortyapi.com/api")
        .addConverterFactory(
            GsonConverterFactory.create()
        ).build()

    private val _rickAndMortyService = _retrofit.create(RickAndMortyService::class.java)

    suspend fun getCharacterById(id: Int) : Character? {

        try{
            val response = _rickAndMortyService.getCharacterById(id)

            if(response.isSuccessful) {
                return response.body()
            } else {
                return null
            }
        } catch (e: Exception) {
            return null
        }

    }
}