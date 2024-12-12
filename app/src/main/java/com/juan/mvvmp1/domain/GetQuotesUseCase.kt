package com.juan.mvvmp1.domain

import com.juan.mvvmp1.data.model.QuoteModel
import com.juan.mvvmp1.data.repositories.QuoteRepository

class GetQuotesUseCase {
    private val quoteRepository = QuoteRepository()

    suspend operator fun invoke(): List<QuoteModel>? =  quoteRepository.getAllQuotes()
}