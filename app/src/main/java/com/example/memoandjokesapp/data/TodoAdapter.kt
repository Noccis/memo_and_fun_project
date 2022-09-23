package com.example.memoandjokesapp.data

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.memoandjokesapp.MemoFragment

import com.example.memoandjokesapp.databinding.TodoItemBinding
import kotlin.math.log

class TodoAdapter(val listOfTodos: MutableList<Todo>, val context: Context) : RecyclerView.Adapter<TodoAdapter.ViewHolder>(){


    override fun getItemCount(): Int {
        return listOfTodos.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = TodoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        with(holder){
            with(listOfTodos[position]){
                binding.tvTodoName.text = this.name
                binding.cbDone.isChecked = this.done
                binding.ibtnDelete.setOnClickListener {
                    Log.d("tag", "Click click")
                    listOfTodos.remove(this)
                    listOfTodos.forEach{
                        Log.d("tag", "Removed! ${it.name}")

                    }

                }
            }
        }
    }

   inner class ViewHolder(val binding: TodoItemBinding): RecyclerView.ViewHolder(binding.root)

}