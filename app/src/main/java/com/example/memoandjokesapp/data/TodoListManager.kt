package com.example.memoandjokesapp.data

object TodoListManager {
    val listOfTodos = mutableListOf<Todo>(
        Todo(0, "Test",  false),
        Todo(0, "Test two", false))

    fun addTodo(name: String){
        val newTodo = Todo(0, name)
        listOfTodos.add(newTodo)
    }
}