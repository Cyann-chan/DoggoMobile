package com.example.doggomobile.presentation

import com.example.doggomobile.api.DoggoApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Singleton {
    companion object {

        val doggoApi: DoggoApi = Retrofit.Builder()
         .baseUrl("https://api.thedogapi.com/v1/")
         .addConverterFactory(GsonConverterFactory.create())
         .build()
         .create(DoggoApi::class.java)}
}