package com.durand.introduction.data.network

import com.durand.introduction.core.RetrofitHelper
import com.durand.introduction.data.model.QuoteModel

class QuoteService {

    private val retrofit = RetrofitHelper.getRetrofit()

    private fun getQuote(): List<QuoteModel> {
        val response = retrofit.create(QuoteApiClient::class.java).getAllQuote()
        return response.body() ?: emptyList()
    }
}