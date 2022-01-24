package com.codingwithmitch.food2forkcompose.presentation.ui.voting_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.codingwithmitch.food2forkcompose.modules.voting.VotingConstants.initialVotes
import com.codingwithmitch.food2forkcompose.modules.voting.VotingLimitsState
import com.codingwithmitch.food2forkcompose.presentation.components.VoteCard

@Composable
fun VotingTopicsList(
    viewModel: VotingTopicsListViewModel,
    onVoteSnackBar: () -> Unit,
    onUnVoteSnackBar: () -> Unit
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

                    Text(
                        text = "Voting Points: ",
                        modifier = Modifier
                            .fillMaxWidth(0.85f)
                            .wrapContentWidth(Alignment.Start),
                        style = MaterialTheme.typography.h5
                    )
                    Text(
                        text =  VotingLimitsState.votingPointsLeft.toString(),
                        modifier = Modifier
                            .fillMaxWidth(0.85f)
                            .wrapContentWidth(Alignment.Start),
                        style = MaterialTheme.typography.h5
                    )
                    VoteCard(
                        topicVote = topic,
                        onTopicVoteIndexChanged = {
                            viewModel.onTopicVoteIndexChanged(topicVoteIndex)
                        },
                        onVote = {
                            viewModel.onTriggerEvent(VotingListEvent.VoteEvent)
                            onVoteSnackBar()
                        },
                        onUnVote = {
                            viewModel.onTriggerEvent(VotingListEvent.UnVoteEvent)
                            onUnVoteSnackBar()
                        }
                    )
                }
            }
        }

}