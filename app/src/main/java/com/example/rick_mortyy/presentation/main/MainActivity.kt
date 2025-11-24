package com.example.rick_mortyy.presentation.main

import android.content.Intent
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rick_mortyy.databinding.ActivityMainBinding
import com.example.rick_mortyy.presentation.adapter.CharactersAdapter
import com.example.rick_mortyy.presentation.base.BaseActivity
import com.example.rick_mortyy.presentation.detailed.DetailedActivity
import com.example.rick_mortyy.presentation.viewmodel.CharacterViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: CharactersAdapter

    private val viewModel: CharacterViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = CharactersAdapter(
            onClick = { id ->
                val intent = Intent(this, DetailedActivity::class.java)
                intent.putExtra("id", id)
                startActivity(intent)
            }
        )

        initAdapter()

        viewModel.getCharacters()
        viewModel.charactersState.handleState(
            onLoading = { isLoading ->
                binding.progressBar.isVisible = isLoading
            },
                onSuccess = { data ->
                    adapter.setData(data)
                }
        )
    }

    private fun initAdapter() = with(binding) {
        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
        recyclerView.adapter = adapter
    }
}