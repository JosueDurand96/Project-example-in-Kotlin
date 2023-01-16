package com.durand.introduction.data

import com.durand.introduction.data.database.dao.QuoteDao
import com.durand.introduction.data.model.QuoteModel
import com.durand.introduction.data.model.QuoteProvider
import com.durand.introduction.data.network.QuoteService
import com.durand.introduction.domain.model.Quote
import com.durand.introduction.domain.model.toDomain
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val api: QuoteService,
    private val quoteDao: QuoteDao
) {
    suspend fun getAllQuotesFromApi(): List<Quote> {
        val response: List<QuoteModel> = api.getQuote()
        return response.map { it.toDomain() }
    }

    suspend fun getAllQuotesFromDatabase(): List<Quote> {
        val response = api.getQuote()
        quoteProvider.quotes = response
        return response
    }
}