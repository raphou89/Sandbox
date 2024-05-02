package org.mathieu.sandbox.domain.repositories

import org.mathieu.sandbox.domain.models.Character

interface ICharacterRepository {
    /**
     * Try to retrieve a character, using its id. If there is no character found, then it returns null.
     *
     * @param id The id of the character that we are looking for
     * @return It returns either a [Character] or null if not found.
     */
    fun getCharacterByIdOrNull(id: Int): Character?

    fun getCharacters(): List<Character>

}