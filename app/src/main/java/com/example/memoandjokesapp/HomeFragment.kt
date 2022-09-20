package com.example.memoandjokesapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

class HomeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_homefragment, container, false)
        val goToJokesButton = view.findViewById<Button>(R.id.btn_jokes)
        goToJokesButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeragment_to_jokesFragment)
        }

        val goToMemosButton = view.findViewById<Button>(R.id.btn_memos)
        goToMemosButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeragment_to_memoFragment)
        }

        return view
    }

}