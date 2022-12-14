package com.example.memoandjokesapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.memoandjokesapp.data.Todo
import com.example.memoandjokesapp.data.TodoAdapter
import com.example.memoandjokesapp.data.TodoRoomDatabase
import com.example.memoandjokesapp.databinding.FragmentMemoBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MemoFragment : Fragment() {

    private var _binding: FragmentMemoBinding? = null
    private val binding get() = _binding!!
    private lateinit var todoAdapter: TodoAdapter
    private lateinit var userInputEditText: EditText
    val listOfTodos = mutableListOf<Todo>()
    lateinit var db: TodoRoomDatabase

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       _binding = FragmentMemoBinding.inflate(inflater, container, false)
        val view = binding.root

        db = Room.databaseBuilder(
            requireContext(),
            TodoRoomDatabase::class.java,
            "todo_database"
        ).build()

        // Setting up my recyclerview
        todoAdapter = TodoAdapter(listOfTodos, requireContext())
        binding.rvTodos.adapter = todoAdapter

        var testList: List<Todo>

        userInputEditText = binding.etUserInput
        val addTodoButton = binding.btnAddTodo
        addTodoButton.setOnClickListener {
            addNewTodo()

        }


        CoroutineScope(Dispatchers.IO).launch {
           val result = db.todoDao().getAllTodos()
            if (result != null){
                testList = result
                Log.d("dodo", "Result is not null! $testList")
                testList.forEach {
                    listOfTodos.add(it)

                }
                withContext(Dispatchers.Main){
                    todoAdapter.notifyDataSetChanged()
                }

            }
        }

        return view
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun addNewTodo(){
        if (userInputEditText.text != null){
            val inputText = userInputEditText.text.toString()
            val newTodo = Todo(0, inputText, false)
            CoroutineScope(Dispatchers.IO).launch {
                db.todoDao().insert(newTodo)
            }
            listOfTodos.add(newTodo)
            todoAdapter.notifyDataSetChanged()
            userInputEditText.setText("")
        }else{
            Toast.makeText(requireContext(), "Invalid input", Toast.LENGTH_SHORT).show()
        }
    }

    fun deleteTodo(todo: Todo){
        db.todoDao().deleteTodo(todo)
    }

}