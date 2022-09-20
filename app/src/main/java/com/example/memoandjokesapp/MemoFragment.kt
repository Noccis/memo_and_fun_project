package com.example.memoandjokesapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.memoandjokesapp.data.TodoAdapter
import com.example.memoandjokesapp.databinding.FragmentMemoBinding

class MemoFragment : Fragment() {

    private var _binding: FragmentMemoBinding? = null
    private val binding get() = _binding!!
    private lateinit var todoAdapter: TodoAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       _binding = FragmentMemoBinding.inflate(inflater, container, false)
        val view = binding.root

        val returnHomeButton = binding.btnReturnHome
        returnHomeButton.setOnClickListener {
            findNavController().navigate(R.id.action_memoFragment_to_homeragment)
        }

        // Setting up my recyclerview
      //  val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(requireContext())
        todoAdapter = TodoAdapter()

        binding.rvTodos.adapter = todoAdapter
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}