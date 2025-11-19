package com.example.rick_mortyy.presentation.ui

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rick_mortyy.R
import com.example.rick_mortyy.presentation.adapter.CartoonAdapter
import com.example.rick_mortyy.presentation.viewmodel.CartoonViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class CounterActivity : AppCompatActivity() {
    private val viewModel: CartoonViewModel by viewModel()

    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var adapter: CartoonAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        progressBar = findViewById(R.id.progressBar)

        adapter = CartoonAdapter()
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        viewModel.getCharacters()
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.charactersState.collect { state ->
                    progressBar.visibility = if (state.isLoading) View.VISIBLE else View.GONE

                    state.error?.let { msg ->
                        if (msg.isNotEmpty()) {
                            Toast.makeText(this@CounterActivity, msg, Toast.LENGTH_SHORT).show()
                        }
                    }

                    state.data?.let { list ->
                        adapter.submitList(list)
                    }
                }
            }
        }
    }
}