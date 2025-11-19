package com.example.rick_mortyy.presentation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.rick_mortyy.R
import com.example.rick_mortyy.domain.models.Character
import com.example.rick_mortyy.presentation.viewmodel.CartoonViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class CounterActivity : AppCompatActivity() {
    private val viewModel: CartoonViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getCharacters()
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.charactersState.collect { data ->
                    displayResult(data)
                }
            }
        }
    }

    private fun displayResult(data: List<Character>) {}
}