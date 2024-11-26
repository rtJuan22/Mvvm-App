package com.juan.mvvmp1.model

class QuoteProvider {
    companion object {
        fun random():QuoteModel{
            val position = (0..6).random()
            return quote[position]
        }
       private val quote = listOf<QuoteModel>(
            QuoteModel(
                quote = "Mazda",
                author = "Juan"
            ),
            QuoteModel(
                quote = "Bmw",
                author = "Juan"
            ),
            QuoteModel(
                quote = "Ford",
                author = "Juan"
            ),
            QuoteModel(
                quote = "Cadilac",
                author = "Juan"
            ),
            QuoteModel(
                quote = "Ferrari",
                author = "Juan"
            )
        )
    }
}