package de.apps.LittleNemo.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun ButtonShare( share: () -> Unit) {
    Button(
        modifier = Modifier.padding(end = 8.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.onSecondary),
        onClick = { share() },

        ) {
        Text(text = "share")
    }
}
