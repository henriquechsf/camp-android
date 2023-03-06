package com.example.marvelapp.presentation.characters

import android.view.View
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.marvelapp.R
import com.example.marvelapp.launchFragmentInHiltContainer
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.hamcrest.Matcher
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
        //onView(isRoot()).perform(waitFor(3000))

        // verifica se o recycler view esta sendo exibido na tela
        onView(withId(R.id.recycler_characters))
            .check(
                matches(isDisplayed())
            )
    }

    private fun waitFor(delay: Long): ViewAction {
        return object : ViewAction {
            override fun getConstraints(): Matcher<View> = isRoot()
            override fun getDescription(): String = "wait for $delay milliseconds"
            override fun perform(uiController: UiController, view: View?) {
                uiController.loopMainThreadForAtLeast(delay)
            }
        }
    }
}