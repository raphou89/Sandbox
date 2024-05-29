package org.mathieu.sandbox.ui.screens.episodes

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import org.mathieu.sandbox.data.EpisodeRepositoryImpl
import org.mathieu.sandbox.domain.models.Character

class EpisodeDetailsViewModel(application: Application) : AndroidViewModel(application) {
    private val _state: MutableStateFlow<EpisodeDetailsState> = MutableStateFlow(EpisodeDetailsState())

    val state: StateFlow<EpisodeDetailsState>
        get() = _state

    // Méthode pour initialiser les détails de l'épisode
    fun initialize(id: Int) {
        val episode = EpisodeRepositoryImpl.getEpisodeById(id)!!

        _state.value = EpisodeDetailsState(
            name = episode.name,
            date = episode.date,
            description = episode.description
        )
    }
}

data class EpisodeDetailsState(
    val name: String = "",
    val date: String = "",
    val description: String = "",
)
