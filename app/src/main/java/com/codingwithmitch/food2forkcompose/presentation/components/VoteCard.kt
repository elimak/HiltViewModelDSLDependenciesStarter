package com.codingwithmitch.food2forkcompose.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.codingwithmitch.food2forkcompose.data.voting.TopicVote
import com.codingwithmitch.food2forkcompose.voting_list.VotingListEvent

/*
topicVote = topic,

topicVoteIndex = topicVoteIndex,
onTopicVoteIndexChanged = viewModel::onTopicVoteIndexChanged,
onVote = {
    viewModel.onTriggerEvent(VotingListEvent.VoteEvent)
},
onUnVote = {
*/

@Composable // TODO topicVote raus und nur topicvote nhemen??
fun VoteCard(topicVote: TopicVote,
             topicVoteIndex:Int,
             onTopicVoteIndexChanged: (Int) -> Unit,
             onVote: () -> Unit,
             onUnVote: () -> Unit
) {
    //var typ = topicVoteState;//[topicVote.id].vote.toString()
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .padding(
                bottom = 6.dp,
                top = 6.dp,
            )
            .fillMaxWidth(),
            //.clickable(onClick = onClick),
        elevation = 8.dp,
    ) {
        Column {
            /*CoilImage(
                data = recipe.featuredImage,
                contentDescription = recipe.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(225.dp),
                contentScale = ContentScale.Crop,
            )*/
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp, bottom = 12.dp, start = 8.dp, end = 8.dp)
            ) {
                Text(
                    text = topicVote.text,
                    modifier = Modifier
                        .fillMaxWidth(0.85f)
                        .wrapContentWidth(Alignment.Start),
                    style = MaterialTheme.typography.h3
                )
                Text(
                    text = topicVote.text.toString(),
                    //text = topicVoteState[index].vote.toString(),
                    //text= votes.toString(),//typ[topicVote.id].vote.toString(),
                    //text = topicVoteState[topicVote.id].vote.toString(),//topicVote.vote.toString() ,
                    modifier = Modifier
                        .fillMaxWidth(0.85f)
                        .wrapContentWidth(Alignment.Start),
                    style = MaterialTheme.typography.h3
                )
                //Button1()

                /*Button(onClick = { /*TODO*/ }) {
                    
                }*/
                //val rank = recipe.rating.toString()
                /*Text(
                    text = rank,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.End)
                        .align(Alignment.CenterVertically),
                    style = MaterialTheme.typography.h5
                )*/
            }

            /*
             topicVote = topic,
                        topicVoteIndex = topicVoteIndex, // index auch in topic vote // TODO
                        onTopicVoteIndexChanged = {
                            viewModel.onTopicVoteIndexChanged(topicVoteIndex)
                        },
                        onVote = {
                            viewModel.onTriggerEvent(VotingListEvent.VoteEvent)
                        },
             */


            Row(modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp, bottom = 12.dp, start = 8.dp, end = 8.dp)
                    ) {
                //Button1(topicVote = topicVote, onClick = onClick,topicVoteState)
                Button1(topicVote = topicVote, onTopicVoteIndexChanged = onTopicVoteIndexChanged,onVote = onVote)
            }
            /*
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp, bottom = 12.dp, start = 8.dp, end = 8.dp)
            ) {
                Button1(topicVote = topicVote, onClick = onClick,topicVoteState)
            }*/

        }
    }

}