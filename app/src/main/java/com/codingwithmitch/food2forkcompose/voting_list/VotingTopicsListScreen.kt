package com.codingwithmitch.food2forkcompose.voting_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.codingwithmitch.food2forkcompose.presentation.components.VoteCard

@Composable
fun VotingTopicsListScreen(
    viewModel: VotingTopicsListViewModel
){
    val topicVoteState  = viewModel.topicVoteState.value
    var topicVoteStateChanged  = viewModel.topicVoteStateChanged.value // TODO it is just a boolean to redraw the composable --> changes in just topicvotestate wont cause a redraw of this composable
    var topicVoteIndex = viewModel.topicVoteIndex


    Box(modifier = Modifier
        .background(color = MaterialTheme.colors.surface)
    ) {

            LazyColumn{
                itemsIndexed(
                    items = topicVoteState
                ) { topicVoteIndex, topic ->

                    VoteCard(
                        topicVote = topic,
                        onTopicVoteIndexChanged = {
                            viewModel.onTopicVoteIndexChanged(topicVoteIndex)
                        },
                        onVote = {
                            viewModel.onTriggerEvent(VotingListEvent.VoteEvent)
                        },
                        onUnVote = {
                            viewModel.onTriggerEvent(VotingListEvent.UnVoteEvent)
                        }
                    )
                }
            }
        }

}