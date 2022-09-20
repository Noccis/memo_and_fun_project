package com.example.memoandjokesapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todo_data_table")
data class Todo (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "todo_id")
    var id: Int,
    @ColumnInfo(name = "todo_name")
    var name: String,
    @ColumnInfo(name = "todo_done")
    var done: Boolean = false
        )
