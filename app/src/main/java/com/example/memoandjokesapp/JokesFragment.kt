package com.example.memoandjokesapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController


class JokesFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_jokes, container, false)

        val returnHomeButton = view.findViewById<Button>(R.id.btn_home)
        returnHomeButton.setOnClickListener {
            findNavController().navigate(R.id.action_jokesFragment_to_homeragment)
        }

        return view
    }


}