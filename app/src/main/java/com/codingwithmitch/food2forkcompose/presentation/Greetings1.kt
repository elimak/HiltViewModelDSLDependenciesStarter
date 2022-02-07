package com.codingwithmitch.food2forkcompose.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.codingwithmitch.food2forkcompose.presentation.ui.Greetings1ViewModel

@Composable
fun Greeting1(name: String, viewModel: Greetings1ViewModel) {
    Text(text = "Hellooooooooo1 $name!")
    Button(
        modifier = Modifier.padding(end = 8.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.onError),
        onClick = {}//negativeAction.onNegativeAction
    ) {
        Text(text = "Button  1")
    }
    Button(
        modifier = Modifier.padding(end = 8.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.onError),
        onClick = {}//negativeAction.onNegativeAction
    ) {
        Text(text = "Button 2")
    }
}