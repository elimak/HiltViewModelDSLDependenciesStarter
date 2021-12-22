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
import com.codingwithmitch.food2forkcompose.data.voting.TopicVote

@Composable
fun Button1(topicVote: TopicVote, onClick: () -> Unit,topicVoteState: List<TopicVote>){


    Button(

        onClick = {

           val d =  topicVoteState
           val c=  topicVoteState

        },
        // in below line we are using modifier
        // which is use to add padding to our button
        modifier = Modifier.padding(all = Dp(10F)),

        // below line is use to set or
        // button as enable or disable.
        enabled = true,

        // below line is use to
        // add border to our button.
        border = BorderStroke(width = 1.dp, brush = SolidColor(Color.Blue)),

        // below line is use to add shape for our button.
        shape = MaterialTheme.shapes.medium,
    )
    // below line is use to
    // add text on our button
    {
        Text(text = "+", color = Color.White)
    }
}
