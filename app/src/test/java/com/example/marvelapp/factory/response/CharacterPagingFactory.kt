package com.example.marvelapp.factory.response

import com.example.core.domain.model.Character
import com.example.core.domain.model.CharacterPaging

class CharacterPagingFactory {

    fun create() = CharacterPaging(
        offset = 0,
        total = 2,
        characters = listOf(
            Character(
                id = 1011334,
                name = "3-D Man",
                imageUrl = "https://any-url.jpg"
            ),
            Character(
                id = 1017100,
                name = "A-Bomb",
                imageUrl = "https://any-url.jpg"
            )
        )
    )
}