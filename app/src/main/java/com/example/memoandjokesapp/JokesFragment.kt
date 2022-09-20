package com.example.memoandjokesapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.memoandjokesapp.data.RetrofitInstance
import com.example.memoandjokesapp.databinding.FragmentJokesBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

val TAG = "tag"
class JokesFragment : Fragment() {

    private var _binding:FragmentJokesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentJokesBinding.inflate(inflater, container, false)
        val view = binding.root

      /*  lifecycleScope.launchWhenCreated {
            getRandomJoke()
        }*/

        val generateNewJokeButton = binding.btnNewJoke
        generateNewJokeButton.setOnClickListener {
           CoroutineScope(Dispatchers.IO).launch {
               getRandomJoke()
           }
        }

        val returnHomeButton = binding.btnHome
        returnHomeButton.setOnClickListener {
            findNavController().navigate(R.id.action_jokesFragment_to_homeragment)
        }
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    private suspend fun getRandomJoke(){

        val joke = RetrofitInstance.api.getJoke()
        if (joke != null){
            Log.d(TAG, "getRandomJoke: $joke")
        }
        /*val response = try {
            RetrofitInstance.api.getJoke()
        }catch (e: IOException){
            Log.e(TAG, "IO exception, you might not have internet connection ")
            return
        }catch (e: HttpException){
            Log.e(TAG, "HTTP Exception unexpected response")
            return
        }
        if (response.isSuccessful && response.body() != null){
            // Set joke text
            Log.d(TAG, "Response successful: $response")
        }else{
            Log.e(TAG, "Response not successful")
        }*/
    }
}
