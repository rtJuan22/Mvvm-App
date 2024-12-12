package com.juan.mvvmp1.ui.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.juan.mvvmp1.databinding.ActivityMainBinding
import com.juan.mvvmp1.ui.viewmodel.QuoteViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    private val quoteViewModel : QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        quoteViewModel.onCreate()

         quoteViewModel.quoteModel.observe(this, Observer { currentQuote ->
             binding.tvQuote.text = currentQuote.quote
             binding.tvAuthor.text = currentQuote.author
         })

           quoteViewModel.isLoading.observe(this, Observer{
               binding.pgBar.isVisible = it
           })
             binding.viewContainer.setOnClickListener {quoteViewModel.randomQuote()}
        }
    }
