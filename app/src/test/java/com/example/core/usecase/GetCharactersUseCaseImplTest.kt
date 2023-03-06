package com.example.core.usecase

import androidx.paging.PagingConfig
import com.example.core.data.repository.CharactersRepository
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import tech.henriquedev.testing.MainCoroutineRule
import tech.henriquedev.testing.model.CharacterFactory
import tech.henriquedev.testing.pagingsource.PagingSourceFactory

@RunWith(MockitoJUnitRunner::class)
class GetCharactersUseCaseImplTest {

    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @Mock
    lateinit var repository: CharactersRepository
    private lateinit var getCharactersUseCase: GetCharactersUseCase
    private val fakePagingSource = PagingSourceFactory().create(
        listOf(CharacterFactory.create(CharacterFactory.Hero.ThreeDMan))
    )

    @Before
    fun setup() {
        getCharactersUseCase = GetCharactersUseCaseImpl(repository)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `should validate flow paging data creation when invoke from use case is called`() = runBlockingTest {
        whenever(repository.getCharacters(""))
            .thenReturn(fakePagingSource)

        val result = getCharactersUseCase
            .invoke(GetCharactersUseCase.Params("", PagingConfig(20)))

        verify(repository).getCharacters("")
        assertNotNull(result.first())
    }
}