package com.durand.introduction.domain

import com.durand.introduction.data.QuoteRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test


internal class GetRandomQuoteUseCaseTest {

    @RelaxedMockK
    private lateinit var quoteRepository: QuoteRepository
    lateinit var getRandomQuoteUseCaseTest: GetRandomQuoteUseCase

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        getRandomQuoteUseCaseTest = GetRandomQuoteUseCase(quoteRepository)
    }

    @Test
    fun  `when the database is empty then return null`() = runBlocking {
        //Given
        coEvery { quoteRepository.getAllQuotesFromDatabase() } returns emptyList()
        //When
        val response = getRandomQuoteUseCaseTest()
        //Then
        assert(response == null)
    }


}