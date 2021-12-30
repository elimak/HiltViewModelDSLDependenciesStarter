package com.codingwithmitch.food2forkcompose.presentation.components


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun ButtonVote(
                onTopicVoteIndexChanged: () -> Unit,
               onVote: () -> Unit,){

    Button(
        onClick = {
            onTopicVoteIndexChanged()
            onVote()

        },
        modifier = Modifier.padding(all = Dp(10F)),
        enabled = true,
        border = BorderStroke(width = 1.dp, brush = SolidColor(Color.Blue)),
        shape = MaterialTheme.shapes.medium,
    )
    {
        Text(text = "+", color = Color.White)
    }
}
