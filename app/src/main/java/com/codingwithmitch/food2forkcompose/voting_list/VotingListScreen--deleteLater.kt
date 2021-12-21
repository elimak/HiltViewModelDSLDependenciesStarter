package com.codingwithmitch.food2forkcompose.voting_list

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
//import androidx.hilt.navigation.compose.hiltViewModel
import com.example.votingapp.voting_list.VotingTopicsListViewModel

@ExperimentalAnimationApi
@Composable
fun Greeting(
  // --- viewModelTopics: VotingTopicsListViewModel = hiltViewModel()
    ) {

   //---val state = viewModelTopics.topicVoteState.value



    //Text(text = state.text)
    Box(
        modifier = androidx.compose.ui.Modifier
            .size(50.dp)
            .padding(80.dp),
    ) {
        FloatingActionButton(
            onClick = {
                //----viewModelTopics.updateText()
            },
            backgroundColor = MaterialTheme.colors.primary
        ) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
        }
    }

}