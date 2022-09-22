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

    val todoApi: TodoJasonApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TodoJasonApi::class.java)
    }

}

