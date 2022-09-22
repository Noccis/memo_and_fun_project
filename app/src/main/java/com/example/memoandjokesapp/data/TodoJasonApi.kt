package com.example.memoandjokesapp.data

import retrofit2.http.GET

interface TodoJasonApi {

    @GET("/todos")
    suspend fun getTodos(): retrofit2.Response<List<TodoJason>>
}