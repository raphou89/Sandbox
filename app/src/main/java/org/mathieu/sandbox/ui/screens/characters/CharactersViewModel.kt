package org.mathieu.sandbox.ui.screens.characters

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.mathieu.sandbox.data.CharacterRepositoryImpl
import org.mathieu.sandbox.domain.models.Character


data class CharactersState(
    val isLoading: Boolean = true,
    val characters: List<Character> = emptyList(),
    val error: String? = null
)

sealed interface CharactersEvent {
    data class NavigateToDetails(val id: Int) : CharactersEvent
}

class CharactersViewModel(application: Application) : AndroidViewModel(application = application) {

    private val _state: MutableStateFlow<CharactersState> = MutableStateFlow(CharactersState())
    val state: StateFlow<CharactersState>
        get() = _state


    private val _events = Channel<CharactersEvent>(kotlinx.coroutines.channels.Channel.BUFFERED)
    val events: Flow<CharactersEvent>
        get() = _events.receiveAsFlow()



    init {

        val characters = CharacterRepositoryImpl.getCharacters()

        _state.update { prevState ->
            prevState.copy(
                isLoading = false,
                characters = characters
            )
        }

    }


    fun navigateToDetail(id: Int) {
        viewModelScope.launch {
            _events.send(CharactersEvent.NavigateToDetails(id = id))
        }
    }


}