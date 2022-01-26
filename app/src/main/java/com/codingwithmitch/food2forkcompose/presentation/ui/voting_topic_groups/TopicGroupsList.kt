package com.codingwithmitch.food2forkcompose.presentation.ui.voting_topic_groups

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.codingwithmitch.food2forkcompose.data.topicGroup.TopicGroup
import com.codingwithmitch.food2forkcompose.modules.voting.VotingLimitsState
import com.codingwithmitch.food2forkcompose.presentation.components.TopicGroupButton
import com.codingwithmitch.food2forkcompose.presentation.components.VoteCard
import com.codingwithmitch.food2forkcompose.presentation.ui.voting_list.VotingListEvent
import com.codingwithmitch.food2forkcompose.presentation.ui.voting_list.VotingTopicsListViewModel

@Composable
fun TopicGroupsList(viewModel: TopicGroupsListViewModel){
    //val topicGroupsState: MutableState<List<TopicGroup>> = mutableStateOf(ArrayList())
    val topicGroupsState  = viewModel.topicGroupsState.value

    Box(modifier = Modifier
        .background(color = MaterialTheme.colors.surface)
    ) {

        LazyColumn{
            itemsIndexed(
                items = topicGroupsState
            ) { topicGroupIndex, topicGroup ->


                TopicGroupButton(topicGroup)
                /*
                Text(
                    text = "Voting Points: ",
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
                )*/
            }
        }
    }
}
