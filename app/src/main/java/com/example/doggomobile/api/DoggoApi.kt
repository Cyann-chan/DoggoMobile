package com.example.doggomobile.api

import retrofit2.Call
import retrofit2.http.GET




interface DoggoApi {
    @GET("breeds")
    fun getDoggoList(): Call<List<DoggoResponse>>
}