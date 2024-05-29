package org.mathieu.sandbox.ui.screens.characterdetails

import android.content.Context
import android.media.MediaPlayer
import android.os.VibrationEffect
import android.os.Vibrator
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import org.mathieu.sandbox.R
import org.mathieu.sandbox.domain.models.Episode


@Composable
fun CharacterDetailsScreen(
    navController: NavController,
    characterId: Int
) {
    val viewModel: CharacterDetailsViewModel = viewModel()
    val state: CharacterDetailsState by viewModel.state.collectAsState()

    LaunchedEffect(key1 = 0) {
        viewModel.initialize(id = characterId)
    }

    LaunchedEffect(viewModel.events) {
        viewModel.events
            .onEach { event ->

                when(event) {
                    is EpisodesEvent.NavigateToDetails -> navController.navigate(
                        route = "episode/${event.id}"
                    )

                    null -> { }
                }

            }.collect()
    }

    Content(
        state = state,
        navigateToEpisodeDetails = { episodeId ->
            viewModel.navigateToDetail(episodeId)
        }
    )
}


@Composable
private fun Content(
    state: CharacterDetailsState,
    navigateToEpisodeDetails: (Int) -> Unit
) = Column {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Text(text = state.firstName)
            Text(text = state.lastName)
        }
    }

    state.episodes.forEach { episode ->
        EpisodeCard(episode = episode, onClick = { navigateToEpisodeDetails(episode.id) })
    }
}

// méthode qui affiche les épisodes sous forme de Card
@Composable
fun EpisodeCard(episode: Episode, onClick: () -> Unit) {
    val context = LocalContext.current
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
            .clickable {
                playSoundAndVibrate(context)
                onClick()
            }
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Text(text = episode.date)
            Text(
                text = episode.name,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview
@Composable
private fun CharacterDetailsPreview() {
    val characterDetailsState = CharacterDetailsState(
        firstName = "John",
        lastName = "Snow",
        episodes = listOf(
            Episode(id = 1, date = "2024-01-01", name = "Episode 1", description = "Description 1"),
            Episode(id = 2, date = "2024-01-02", name = "Episode 2", description = "Description 1"),
            Episode(id = 3, date = "2024-01-03", name = "Episode 3", description = "Description 1")
        )
    )

    Content(
        state = characterDetailsState,
        navigateToEpisodeDetails = {}
    )
}

private fun playSoundAndVibrate(context: Context) {
    val song = MediaPlayer.create(context, R.raw.klaxon_song) // ref au song dans res/raw/klaxon_song
    song.start()

    val vibrator = context.getSystemService(Vibrator::class.java)
    vibrator?.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE)) // vibre pdt une durée de 0,1s
        }

@Preview
@Composable
fun EpisodeCardPreview() {
    EpisodeCard(
        episode = Episode(
            id = 1,
            date = "2024-01-01",
            name = "Episode 1",
            description = "Description 1"
        ),
        onClick = {}
    )
}
