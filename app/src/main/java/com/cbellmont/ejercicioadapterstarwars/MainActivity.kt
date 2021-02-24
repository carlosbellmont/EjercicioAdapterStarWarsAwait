package com.cbellmont.ejercicioadapterstarwars

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.cbellmont.ejercicioadapterstarwars.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private var adapter : FilmsAdapter = FilmsAdapter()
    private lateinit var model :MainActivityViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        model = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        createRecyclerView()
        downloadAll()
    }

    private fun createRecyclerView() {
        binding.filmRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.filmRecyclerView.adapter = adapter
    }


    private fun downloadAll(){
        lifecycleScope.launch {
            binding.pbLoading.visibility = View.VISIBLE
            val list = model.getFilms()
            Log.w("CARLOS", list.toString())
            adapter.updateFilms(list)
            binding.pbLoading.visibility = View.GONE
        }
    }


}