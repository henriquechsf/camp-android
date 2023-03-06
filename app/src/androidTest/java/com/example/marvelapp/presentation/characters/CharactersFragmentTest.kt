package com.example.marvelapp.presentation.characters

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.marvelapp.launchFragmentInHiltContainer
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
class CharactersFragmentTest {

    // usado em fragment que utiliza o Hilt
    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    // Inicializa um fragmento em uma activity vazia
    @Before
    fun setup() {
        launchFragmentInHiltContainer<CharactersFragment>() // usa config do arquivo HiltExt
    }

    @Test
    fun shouldShowCharacters_whenViewIsCreated() {

    }
}