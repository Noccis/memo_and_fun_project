package com.example.memoandjokesapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.memoandjokesapp.data.TodoAdapter
import com.example.memoandjokesapp.data.TodoListManager
import com.example.memoandjokesapp.databinding.FragmentMemoBinding

class MemoFragment : Fragment() {

    private var _binding: FragmentMemoBinding? = null
    private val binding get() = _binding!!
    private lateinit var todoAdapter: TodoAdapter
    private lateinit var userInputEditText: EditText

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       _binding = FragmentMemoBinding.inflate(inflater, container, false)
        val view = binding.root

        /*val returnHomeButton = binding.btnReturnHome
        returnHomeButton.setOnClickListener {
            findNavController().navigate(R.id.action_memoFragment_to_homeragment)
        }*/

        // Setting up my recyclerview
        todoAdapter = TodoAdapter()
        binding.rvTodos.adapter = todoAdapter

        userInputEditText = binding.etUserInput
        val addTodoButton = binding.btnAddTodo
        addTodoButton.setOnClickListener {
            addNewTodo()
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
            TodoListManager.addTodo(inputText)
            todoAdapter.notifyDataSetChanged()
            userInputEditText.setText("")
        }else{
            Toast.makeText(requireContext(), "Invalid input", Toast.LENGTH_SHORT).show()
        }
    }

}