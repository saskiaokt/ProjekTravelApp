package com.example.projektravelapp.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface TravelApi {
    @GET("/rest/v1/todo?select=*")
    suspend fun get(
        @Header("Authorization") token: String,
        @Header("apikey") apiKey: String
    ) : Response<List<TodoItem>>
}