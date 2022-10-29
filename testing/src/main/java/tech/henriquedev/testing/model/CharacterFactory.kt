package tech.henriquedev.testing.model

import com.example.core.domain.model.Character

class CharacterFactory {

    companion object {
        fun create(hero: Hero) = when (hero) {
            Hero.ThreeDMan -> Character("3-D Man", "https://any-url.jpg")
            Hero.ABomb -> Character("A-Bomb", "https://any-url.jpg")
        }
    }

    sealed class Hero {
        object ThreeDMan : Hero()
        object ABomb : Hero()
    }
}