package com.durand.introduction.ui.view

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.durand.introduction.databinding.ActivityMainBinding
import com.durand.introduction.ui.viewModel.QuoteViewModel
import androidx.lifecycle.Observer

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val quoteViewModel: QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        quoteViewModel.onCreate()

        binding.viewContainer.setOnClickListener {
            quoteViewModel.randomQuote()
        }

        quoteViewModel.quoteModel.observe(this, Observer {
            binding.tvQuote.text = it.quote
            binding.tvAuthor.text = it.author
        })


        quoteViewModel.isLoading.observe(this, Observer {
            binding.progress.isVisible = it
        })
    }
}