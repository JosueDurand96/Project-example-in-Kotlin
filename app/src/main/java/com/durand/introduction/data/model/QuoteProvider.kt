package com.durand.introduction.data.model

import javax.inject.Inject

class QuoteProvider @Inject constructor() {
    var quotes: List<QuoteModel> = emptyList()
}