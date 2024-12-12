package com.juan.mvvmp1.domain

import com.juan.mvvmp1.data.model.QuoteModel
import com.juan.mvvmp1.data.model.QuoteProvider
import com.juan.mvvmp1.data.repositories.QuoteRepository

class GetRandomQuoteUseCase {
    operator fun invoke():QuoteModel?{
        val quotes = QuoteProvider.quotes
        if (!quotes.isNullOrEmpty()){
            val randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }
}