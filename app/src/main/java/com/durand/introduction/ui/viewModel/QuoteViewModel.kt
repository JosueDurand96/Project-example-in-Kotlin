package com.durand.introduction.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.durand.introduction.data.model.QuoteModel
import com.durand.introduction.data.model.QuoteProvider
import com.durand.introduction.domain.GetQuotesUseCase
import com.durand.introduction.domain.GetRandomQuoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor(
    private val getQuotesUseCase: GetQuotesUseCase,
    private val getRandomQuoteUseCase: GetRandomQuoteUseCase
) : ViewModel() {

    val quoteModel = MutableLiveData<QuoteModel>()
    val isLoading = MutableLiveData<Boolean>()


    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getQuotesUseCase()
            if (!result.isNullOrEmpty()) {
                quoteModel.postValue(result[0])
                isLoading.postValue(false)
            }
        }
    }

    fun randomQuote() {
        isLoading.postValue(true)
        val quote = getRandomQuoteUseCase()
        if (quote != null) {
            quoteModel.postValue(quote)
        }
        isLoading.postValue(false)
        //  val currentQuote = QuoteProvider.random()
        //  quoteModel.postValue(currentQuote)
    }

}