package com.durand.introduction.domain

import com.durand.introduction.data.QuoteRepository
import com.durand.introduction.data.model.QuoteModel
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(private val repository: QuoteRepository){

    suspend operator fun invoke():List<QuoteModel>?{
        return  repository.getAllQuote()
    }
}