package com.codingwithmitch.food2forkcompose.voting_list

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
//import androidx.hilt.navigation.compose.hiltViewModel
import com.codingwithmitch.food2forkcompose.data.voting.TopicVote
import com.codingwithmitch.food2forkcompose.presentation.components.VoteCard

@Composable
fun TopicsList(
    viewModel: VotingTopicsListViewModel //= hiltViewModel()
/*
    loading: Boolean,
    recipes: List<Recipe>,
    onChangeScrollPosition: (Int) -> Unit,
    page: Int,
    onTriggerNextPage: () -> Unit,
    onNavigateToRecipeDetailScreen: (String) -> Unit,

     */
){
    val topicVoteState  = viewModel.topicVoteState.value
    var topicVoteStateChanged  = viewModel.topicVoteStateChanged.value // TODO it is just a boolean to redraw the composable --> changes in just topicvotestate wont cause a redraw of this composable
    var topicVoteIndex = viewModel.topicVoteIndex

//////// -- testing
    var count  = viewModel.count.value
    ///// -- testing

    // nur durch eine loading variable checkd or das !!!
    //var count2  = viewModelTopics.count2.value
    //--val counterState = remember { mutableStateOf(count2) }
    ///////

    Box(modifier = Modifier
        .background(color = MaterialTheme.colors.surface)
    ) {

//////////////----------- testing

        /*
        Button(onClick = { viewModel.onTriggerEvent() }) {

            //Text(text = counterState.value.toString())
            //-----Text(text = count2.toString())
            Text(text = count[1].toString()) // or only count count
            //Text(text = count[1].toString())
        }
*/

        ////////////////////////////-----

        // todo id  dazu //

        /*
        var topics:  MutableList<TopicVote> = mutableListOf()
        topics.add(TopicVote(0,"a",1))
        topics.add(TopicVote(1,"b",1))
        topics.add(TopicVote(2,"c",1))

         */
/////////////

        //onTopicVoteIndexChanged
        //onTriggerEvent
        //VotingListEvent.VoteEvent




////////////////////////////////////////////////////////
        //var topics:  List<TopicVote> = topicVoteState
            LazyColumn{
                itemsIndexed(
                    items = topicVoteState//topics
                ) { topicVoteIndex, topic ->

                    VoteCard(
                        topicVote = topic,
                        topicVoteIndex = topicVoteIndex, // index auch in topic vote // TODO
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
        ////////////////////////////////////
        }

}



