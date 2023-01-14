package com.durand.introduction.data.network

import com.durand.introduction.core.RetrofitHelper
import com.durand.introduction.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class QuoteService @Inject constructor(){

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getQuote(): List<QuoteModel> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(QuoteApiClient::class.java).getAllQuote()
            response.body() ?: emptyList()
        }
    }
}