package com.juan.mvvmp1.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.juan.mvvmp1.model.QuoteModel
import com.juan.mvvmp1.model.QuoteProvider

class QuoteViewModel : ViewModel(){

    val quoteModel = MutableLiveData<QuoteModel>()

    fun randomQuote(){
        val currentQuote = QuoteProvider.random()
        quoteModel.postValue(currentQuote)
    }
}