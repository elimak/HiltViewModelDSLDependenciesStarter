package de.apps.LittleNemo.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import de.apps.LittleNemo.presentation.ui.picture_collection.PictureCollectionViewModel


@Composable
fun ButtonNext( viewModel: PictureCollectionViewModel) {
    Button(
        modifier = Modifier.padding(end = 8.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.onSecondary),
        onClick = { viewModel.previousPicture() },


        ) {
        Text(text = "next")
    }
}
@Composable
fun ButtonPrev( viewModel: PictureCollectionViewModel) {
    Button(
        modifier = Modifier.padding(end = 8.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.onSecondary),
        //onClick = { viewModel.nextPicture() }
        onClick = { viewModel.onTriggerEvent() } // TODO TESTING
    ) {
        Text(text = "prev")
    }
}