package com.durand.introduction.domain.model

import com.durand.introduction.data.database.entities.QuoteEntity
import com.durand.introduction.data.model.QuoteModel

data class Quote(val quote: String, val author: String)

fun QuoteModel.toDomain() = Quote(quote, author)

fun QuoteEntity.toDomain() = Quote(quote, author)