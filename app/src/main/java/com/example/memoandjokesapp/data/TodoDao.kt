package com.example.memoandjokesapp.data

import android.icu.lang.UCharacter.WordBreak
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TodoDao {
    @Query("SELECT * FROM todo_table")
    fun getAllTodos(): MutableList<Todo>

    @Insert
    fun insert(vararg todo: Todo)
}