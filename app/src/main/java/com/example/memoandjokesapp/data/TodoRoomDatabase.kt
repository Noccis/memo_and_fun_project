package com.example.memoandjokesapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.CoroutineScope

@Database(entities = [Todo::class], version = 1)
abstract class TodoRoomDatabase : RoomDatabase(){
    abstract fun todoDao(): TodoDao

}
