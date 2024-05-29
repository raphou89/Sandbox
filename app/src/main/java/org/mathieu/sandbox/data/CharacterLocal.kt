package org.mathieu.sandbox.data

import org.mathieu.sandbox.domain.models.Character

object CharacterLocal {
    var characters: MutableList<Character> = mutableListOf(
        Character(
            id = 1,
            firstName = "John",
            lastName = "Snow",
            age = 20,
            episodes = EpisodeLocal.episodes.subList(0, 2)
        ),
        Character(
            id = 2,
            firstName = "Jack",
            lastName = "Sparrow",
            age = 21,
            episodes = EpisodeLocal.episodes.subList(2, 4)
        ),
        Character(
            id = 3,
            firstName = "Jordan",
            lastName = "Emma",
            age = 22,
            episodes = EpisodeLocal.episodes.subList(4, 5)
        )
    )
}
