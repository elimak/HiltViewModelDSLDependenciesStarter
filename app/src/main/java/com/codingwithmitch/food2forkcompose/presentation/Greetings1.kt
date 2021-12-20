package com.codingwithmitch.food2forkcompose.presentation

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.codingwithmitch.food2forkcompose.presentation.ui.Greetings1ViewModel

@Composable
fun Greeting1(name: String, viewModel: Greetings1ViewModel) {
    Text(text = "Hellooooooooo1 $name!")

}