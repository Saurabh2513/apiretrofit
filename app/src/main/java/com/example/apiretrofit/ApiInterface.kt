package com.example.apiretrofit

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("/new")
    fun getData(): Call<List<Book>>



}