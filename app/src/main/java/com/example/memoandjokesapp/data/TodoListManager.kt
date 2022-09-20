package com.example.memoandjokesapp.data

object TodoListManager {
    val listOfTodos = mutableListOf<Todo>(
        Todo("Test",  false),
        Todo("Test two", false))

    fun addTodo(name: String){
        val newTodo = Todo(name)
        listOfTodos.add(newTodo)
    }
}