package com.juan.mvvmp1.data.repositories

import com.juan.mvvmp1.data.model.QuoteModel
import com.juan.mvvmp1.data.model.QuoteProvider
import com.juan.mvvmp1.data.network.QuoteService

class QuoteRepository {
    private val quoteService = QuoteService()

    suspend fun  getAllQuotes(): List<QuoteModel>{
        val response = quoteService.getQuotes()
        QuoteProvider.quotes = response
        return response
    }
}