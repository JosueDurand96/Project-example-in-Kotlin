package com.durand.introduction.data.network

import com.durand.introduction.data.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApiClient {
    @GET("/.json")
    suspend fun getAllQuote():Response<List<QuoteModel>>

}