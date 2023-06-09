package com.example.core.usecase

import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.core.data.repository.CharactersRepository
import com.example.core.data.repository.StorageRepository
import com.example.core.domain.model.Character
import com.example.core.usecase.base.PagingUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

interface GetCharactersUseCase {
    operator fun invoke(params: Params): Flow<PagingData<Character>>

    data class Params(
        val query: String,
        val pagingConfig: PagingConfig,
    )
}

class GetCharactersUseCaseImpl @Inject constructor(
    private val charactersRepository: CharactersRepository,
    private val storageRepository: StorageRepository,
) : PagingUseCase<GetCharactersUseCase.Params, Character>(),
    GetCharactersUseCase {

    override fun createFlowObservable(params: GetCharactersUseCase.Params): Flow<PagingData<Character>> {
        val orderBy = runBlocking { storageRepository.sorting.first() }
        return charactersRepository.getCachedCharacters(params.query, orderBy, params.pagingConfig)
    }
}