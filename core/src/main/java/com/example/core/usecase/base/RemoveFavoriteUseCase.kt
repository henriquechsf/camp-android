package com.example.core.usecase.base

import com.example.core.data.repository.FavoritesRepository
import com.example.core.domain.model.Character
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface RemoveFavoriteUseCase {

    operator fun invoke(params: Params): Flow<ResultStatus<Unit>>

    data class Params(val characterId: Int, val name: String, val imageUrl: String)
}

class RemoveFavoriteUseCaseImpl @Inject constructor(
    private val favoritesRepository: FavoritesRepository,
    private val dispatchers: CoroutinesDispatchers,
) : UseCase<RemoveFavoriteUseCase.Params, Unit>(), RemoveFavoriteUseCase {

    override suspend fun doWork(params: RemoveFavoriteUseCase.Params): ResultStatus<Unit> {
        return withContext(dispatchers.io()) {
            favoritesRepository.deleteFavorite(
                Character(
                    params.characterId,
                    params.name,
                    params.imageUrl
                )
            )
            ResultStatus.Success(Unit)
        }
    }
}