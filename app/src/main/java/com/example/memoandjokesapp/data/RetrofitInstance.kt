package com.example.memoandjokesapp.data

import android.util.Log
import com.example.memoandjokesapp.TAG
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    init {
        Log.d(TAG, "Creating RetrofitInstance: ")
    }
    val api: JokeApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.chucknorris.io")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(JokeApi::class.java)
    }
}

