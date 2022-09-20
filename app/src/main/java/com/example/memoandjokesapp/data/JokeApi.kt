package com.example.memoandjokesapp.data

import retrofit2.Response
import retrofit2.http.GET

interface JokeApi {

    @GET("/jokes/random")
    suspend fun getJoke(): Response<Joke>
}
