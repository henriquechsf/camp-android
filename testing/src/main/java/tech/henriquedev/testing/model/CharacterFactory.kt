package tech.henriquedev.testing.model

import com.example.core.domain.model.Character

class CharacterFactory {

    companion object {
        fun create(hero: Hero) = when (hero) {
            Hero.ThreeDMan -> Character(
                id = 100,
                name = "3-D Man",
                imageUrl = "https://any-url.jpg"
            )
            Hero.ABomb -> Character(id = 101, name = "A-Bomb", imageUrl = "https://any-url.jpg")
        }
    }

    sealed class Hero {
        object ThreeDMan : Hero()
        object ABomb : Hero()
    }
}