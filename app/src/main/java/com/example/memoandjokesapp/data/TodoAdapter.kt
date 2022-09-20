package com.example.memoandjokesapp.data

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.example.memoandjokesapp.databinding.TodoItemBinding

class TodoAdapter : RecyclerView.Adapter<TodoAdapter.ViewHolder>(){

    override fun getItemCount(): Int {
        return TodoListManager.listOfTodos.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = TodoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(TodoListManager.listOfTodos[position]){
                binding.tvTodoName.text = this.name
                binding.cbDone.isChecked = this.done
            }
        }
    }

   inner class ViewHolder(val binding: TodoItemBinding): RecyclerView.ViewHolder(binding.root)

}