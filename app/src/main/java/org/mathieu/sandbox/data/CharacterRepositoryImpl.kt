package org.mathieu.sandbox.data

import org.mathieu.sandbox.domain.models.Character
import org.mathieu.sandbox.domain.repositories.ICharacterRepository

object CharacterRepositoryImpl : ICharacterRepository {

    /**
     * Try to retrieve a character, using its id. If there is no character found, then it returns null.
     *
     * @param id The id of the character that we are looking for
     * @return It returns either a [Character] or null if not found.
     */
    override fun getCharacterByIdOrNull(id: Int): Character? {

        return CharacterLocal.characters.find { character ->
            character.id == id
        }

    }

    override fun getCharacters() = CharacterLocal.characters

}