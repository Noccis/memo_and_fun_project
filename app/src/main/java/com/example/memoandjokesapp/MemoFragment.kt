package com.example.memoandjokesapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.memoandjokesapp.databinding.FragmentMemoBinding

class MemoFragment : Fragment() {

    private var _binding: FragmentMemoBinding? = null
    private val binding get() = _binding!!

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

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}