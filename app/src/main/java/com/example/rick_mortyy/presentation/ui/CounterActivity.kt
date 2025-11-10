package com.example.rick_mortyy.presentation.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.rick_mortyy.databinding.ActivityMainBinding

class CounterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //1
        Glide.with(this)
            .load("https://rickandmortyapi.com/api/character/avatar/135.jpeg")
            .centerCrop()
            .into(binding.imageGarment)
        //2
        Glide.with(this)
            .load("https://rickandmortyapi.com/api/character/avatar/246.jpeg")
            .centerCrop()
            .into(binding.imagePancakes)
        //3
        Glide.with(this)
            .load("https://rickandmortyapi.com/api/character/avatar/251.jpeg")
            .centerCrop()
            .into(binding.imageNancy)
        //4
        Glide.with(this)
            .load("https://rickandmortyapi.com/api/character/avatar/405.jpeg")
            .centerCrop()
            .into(binding.imageTrunkphobic)
        //5
        Glide.with(this)
            .load("https://rickandmortyapi.com/api/character/avatar/457.jpeg")
            .centerCrop()
            .into(binding.imageFunny)
        //6
        Glide.with(this)
            .load("https://rickandmortyapi.com/api/character/avatar/662.jpeg")
            .centerCrop()
            .into(binding.imageGaia)
    }
}