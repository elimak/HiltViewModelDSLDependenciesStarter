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
    val query = viewModel.query.value
    //horizontalAlignment = Alignment.End
    //modifier = Modifier.fillMaxSize(),
    //verticalArrangement = Arrangement.Bottom

    Column (modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom
        ) {

        //Text(text = "Hellooooooooo1 +$query+ $name!")

        Row(
            horizontalArrangement = Arrangement.End,
            //horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.onPrimary)
                .padding(10.dp)
        ) {
            Button(
                modifier = Modifier.padding(end = 8.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.onError),
                onClick = { viewModel.changeQuerry() }//negativeAction.onNegativeAction
            ) {
                Text(text = "Button  1")
            }
            Button(
                modifier = Modifier.padding(end = 8.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.onError),
                onClick = { viewModel.changeQuerry() }//negativeAction.onNegativeAction
            ) {
                Text(text = "Button  2")
            }
        }
    }
    /*
    Button(
        modifier = Modifier.padding(end = 8.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.onError),
        onClick = {}//negativeAction.onNegativeAction
    ) {
        Text(text = "Button 2")
    }*/
}