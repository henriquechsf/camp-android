package com.example.marvelapp.framework.di

import com.example.core.usecase.GetCharacterCategoriesUseCase
import com.example.core.usecase.GetCharacterCategoriesUseCaseImpl
import com.example.core.usecase.GetCharactersUseCase
import com.example.core.usecase.GetCharactersUseCaseImpl
import com.example.core.usecase.AddFavoriteUseCase
import com.example.core.usecase.AddFavoriteUseCaseImpl
import com.example.core.usecase.CheckFavoriteUseCase
import com.example.core.usecase.CheckFavoriteUseCaseImpl
import com.example.core.usecase.GetCharactersSortingUseCase
import com.example.core.usecase.GetCharactersSortingUseCaseImpl
import com.example.core.usecase.GetFavoritesUseCase
import com.example.core.usecase.GetFavoritesUseCaseImpl
import com.example.core.usecase.SaveCharacterSortingUseCase
import com.example.core.usecase.SaveCharacterSortingUseCaseImpl
import com.example.core.usecase.base.RemoveFavoriteUseCase
import com.example.core.usecase.base.RemoveFavoriteUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface UseCaseModule {

    @Binds
    fun bindGetCharactersUseCase(useCase: GetCharactersUseCaseImpl): GetCharactersUseCase

    @Binds
    fun bindGetCharacterCategoriesUseCase(
        useCase: GetCharacterCategoriesUseCaseImpl,
    ): GetCharacterCategoriesUseCase

    @Binds
    fun bindAddFavoriteUseCase(useCase: AddFavoriteUseCaseImpl): AddFavoriteUseCase

    @Binds
    fun bindCheckFavoriteUseCase(useCase: CheckFavoriteUseCaseImpl): CheckFavoriteUseCase

    @Binds
    fun bindRemoveFavoriteUseCase(useCase: RemoveFavoriteUseCaseImpl): RemoveFavoriteUseCase

    @Binds
    fun bindGetFavoritesUseCase(useCase: GetFavoritesUseCaseImpl): GetFavoritesUseCase

    @Binds
    fun bindGetCharacterSortingUseCase(
        useCase: GetCharactersSortingUseCaseImpl,
    ): GetCharactersSortingUseCase

    @Binds
    fun bindSaveCharacterSortingUseCase(
        useCase: SaveCharacterSortingUseCaseImpl
    ): SaveCharacterSortingUseCase
}