package com.example.doggomobile.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface DoggoApi {
    @GET("breeds")
    fun getDoggoList(): Call<List<DoggoListResponse>>

    @GET("breeds/search")
    fun getDoggoDetail (@Query("q") q: String): Call<DoggoDetailResponse>
}
