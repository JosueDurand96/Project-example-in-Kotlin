package com.durand.introduction.model

class QuoteProvider {
    companion object {

        fun random(): QuoteModel {
            val position = (0..6).random()
            return quote[position]
        }

        private val quote = listOf<QuoteModel>(
            QuoteModel(quote = "Example 0", author = "Josue Durand"),
            QuoteModel(quote = "Example 1", author = "Josh Durand"),
            QuoteModel(quote = "Example 2", author = "Maria"),
            QuoteModel(quote = "Example 3", author = "Jesus"),
            QuoteModel(quote = "Example 4", author = "Haydee"),
            QuoteModel(quote = "Example 5", author = "Sofia"),
            QuoteModel(quote = "Example 6", author = "Jennifer")
        )
    }

}