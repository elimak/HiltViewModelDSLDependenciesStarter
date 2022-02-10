package com.codingwithmitch.food2forkcompose.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
//import androidx.compose.ui.tooling.preview.Preview
import com.codingwithmitch.food2forkcompose.presentation.ui.Greetings1ViewModel


@Composable
fun testi(){
    Text(text = "Hellooooooooo1 55555")
}



@Composable
fun Greeting1(name: String, viewModel: Greetings1ViewModel) {
    val currentPictureIndex = viewModel.currentPictureIndex.value
    val picturesState  = viewModel.picturesState.value
   // var topicVoteStateChanged  = viewModel.topicVoteStateChanged.value // TODO it is just a boolean to redraw the composable --> changes in just topicvotestate wont cause a redraw of this composable

    testi()
    Column (modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom
        ) {
        var pictureName = picturesState[currentPictureIndex].link
        Text(text = "$pictureName")

        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.onPrimary)
                .padding(10.dp)
        ) {
            if(currentPictureIndex !==0) {
                Button(
                    modifier = Modifier.padding(end = 8.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.onError),
                    onClick = { viewModel.previousPicture() }
                ) {
                    Text(text = "prev")
                }
            }
            if(currentPictureIndex < picturesState.size-1){
            Button(
                modifier = Modifier.padding(end = 8.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.onError),
                onClick = { viewModel.nextPicture() }
            ) {
                Text(text = "next")
            }
        }
            val test = 33
        }
    }

}