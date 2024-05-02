package org.mathieu.sandbox.ui.screens.characterdetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController


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

    Content(
        state = state
    )
}


@Composable
private fun Content(
    state: CharacterDetailsState
) = Column {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        Text(text = state.firstName)
        Text(text = state.lastName)
    }

}


@Preview
@Composable
private fun Preview() {
    Content(
        state = CharacterDetailsState()
    )
}