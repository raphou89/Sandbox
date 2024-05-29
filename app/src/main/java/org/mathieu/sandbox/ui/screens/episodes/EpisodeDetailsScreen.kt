package org.mathieu.sandbox.ui.screens.episodes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.mathieu.sandbox.ui.core.theme.PurpleTealGradientStart
import org.mathieu.sandbox.ui.core.theme.PurpleTealGradientEnd

@Composable
fun EpisodeDetailsScreen(
    navController: NavController,
    episodeId: Int
) {
    val viewModel: EpisodeDetailsViewModel = viewModel()
    val state = viewModel.state.collectAsState().value

    LaunchedEffect(key1 = 0) {
        viewModel.initialize(id = episodeId)
    }

    Content(
        state = state
    )
}

@Composable
private fun Content(
    state: EpisodeDetailsState
) = Column(
    modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
        .background(
            brush = Brush.verticalGradient(
                colors = listOf(Color.Black, Color.DarkGray)
            )
        )
        .padding(16.dp)
) {
    Text(
        text = "Nom de l'épisode: ${state.name}",
        modifier = Modifier
            .padding(bottom = 8.dp)
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(PurpleTealGradientStart, PurpleTealGradientEnd)
                )
            )
            .padding(8.dp),
        color = Color.White,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold
    )
    Text(
        text = "Date: ${state.date}",
        modifier = Modifier
            .padding(bottom = 8.dp)
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(PurpleTealGradientStart, PurpleTealGradientEnd)
                )
            )
            .padding(8.dp),
        color = Color.White,
        fontSize = 18.sp,
        fontWeight = FontWeight.Medium
    )
    Text(
        text = "Détail: ${state.description}",
        modifier = Modifier
            .padding(bottom = 8.dp)
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(PurpleTealGradientStart, PurpleTealGradientEnd)
                )
            )
            .padding(8.dp),
        color = Color.White,
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewEpisodeDetailsScreen() {
    val sampleState = EpisodeDetailsState(
        name = "Le Commencement",
        date = "2024-01-01",
        description = "Dans ce premier épisode, nous rencontrons les personnages principaux et découvrons le monde fascinant dans lequel ils évoluent."
    )
    Content(state = sampleState)
}
