package com.durand.introduction.domain

import com.durand.introduction.data.QuoteRepository
import com.durand.introduction.data.model.QuoteModel
import com.durand.introduction.data.model.QuoteProvider
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor() {
    private val repository = QuoteRepository()

    operator fun invoke(): QuoteModel? {
        val quotes = QuoteProvider.quotes
        if (!quotes.isNullOrEmpty()) {
            val randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }
}