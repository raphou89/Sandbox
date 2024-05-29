package org.mathieu.sandbox.ui.screens.characterdetails

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import org.mathieu.sandbox.data.CharacterRepositoryImpl
import org.mathieu.sandbox.domain.models.Episode
import org.mathieu.sandbox.ui.screens.characters.CharactersEvent


sealed interface EpisodesEvent {
    data class NavigateToDetails(val id: Int) : EpisodesEvent
}

class CharacterDetailsViewModel(application: Application) : AndroidViewModel(application) {
    private val _state: MutableStateFlow<CharacterDetailsState> = MutableStateFlow(CharacterDetailsState())

    val state: StateFlow<CharacterDetailsState>
        get() = _state

    private val _events = Channel<EpisodesEvent>(Channel.BUFFERED)
    val events: Flow<EpisodesEvent>
        get() = _events.receiveAsFlow()

    fun initialize(id: Int) {
        val character = CharacterRepositoryImpl.getCharacterByIdOrNull(id)!!

        _state.value = CharacterDetailsState(
            firstName = character.firstName,
            lastName = character.lastName,
            episodes = character.episodes
        )

    }

    fun navigateToDetail(id: Int) {
        viewModelScope.launch {
            _events.send(EpisodesEvent.NavigateToDetails(id = id))
        }
    }

}

data class CharacterDetailsState(
    val firstName: String = "",
    val lastName: String = "",
    val episodes: List<Episode> = emptyList()
)
