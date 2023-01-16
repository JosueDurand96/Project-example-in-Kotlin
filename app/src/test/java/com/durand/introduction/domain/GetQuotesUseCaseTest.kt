package com.durand.introduction.domain

import com.durand.introduction.data.QuoteRepository
import io.mockk.impl.annotations.RelaxedMockK
import org.junit.Before


class GetQuotesUseCaseTest{

    @RelaxedMockK
    private lateinit var repository: QuoteRepository

    @Before
    fun onBefore(){

    }

}