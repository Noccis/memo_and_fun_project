package com.example.memoandjokesapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.memoandjokesapp.databinding.FragmentHomefragmentBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomefragmentBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomefragmentBinding.inflate(inflater, container, false)
        val view = binding.root

        val goToJokesButton = binding.btnJokes
        goToJokesButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeragment_to_jokesFragment)
        }

        val goToMemosButton = binding.btnMemos
        goToMemosButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeragment_to_memoFragment)
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}