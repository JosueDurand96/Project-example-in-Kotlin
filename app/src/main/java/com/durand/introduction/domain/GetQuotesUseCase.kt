package com.durand.introduction.domain

import com.durand.introduction.data.QuoteRepository
import com.durand.introduction.data.database.entities.toDatabase
import com.durand.introduction.domain.model.Quote
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(private val repository: QuoteRepository) {

    suspend operator fun invoke(): List<Quote> {
        val quotes = repository.getAllQuotesFromApi()
        return if (!quotes.isNullOrEmpty()) {
            repository.insertQuotesDatabase(quotes.map { it.toDatabase() })
            quotes
        } else {
            repository.getAllQuotesFromDatabase()
        }
    }
}