package com.durand.introduction.data

import com.durand.introduction.data.model.QuoteModel
import com.durand.introduction.data.model.QuoteProvider
import com.durand.introduction.data.network.QuoteService
import javax.inject.Inject

class QuoteRepository @Inject constructor(private val api: QuoteService) {
    suspend fun getAllQuote(): List<QuoteModel> {
        val response = api.getQuote()
        QuoteProvider.quotes = response
        return response
    }
}