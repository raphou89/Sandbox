package org.mathieu.sandbox.ui.screens.characterdetails

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import org.mathieu.sandbox.data.CharacterRepositoryImpl

class CharacterDetailsViewModel(application: Application) : AndroidViewModel(application) {
    private val _state: MutableStateFlow<CharacterDetailsState> = MutableStateFlow(CharacterDetailsState())

    val state: StateFlow<CharacterDetailsState>
        get() = _state

    fun initialize(id: Int) {
        val character = CharacterRepositoryImpl.getCharacterByIdOrNull(id)!!

        _state.value = CharacterDetailsState(
            firstName = character.firstName,
            lastName = character.lastName
        )

    }

}



data class CharacterDetailsState(
    val firstName: String = "",
    val lastName: String = ""
)