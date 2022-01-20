package com.codingwithmitch.food2forkcompose.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.codingwithmitch.food2forkcompose.data.voting.TopicVote


@Composable
fun VoteCard(topicVote: TopicVote,
             onTopicVoteIndexChanged: () -> Unit,
             onVote: () -> Unit,
             onUnVote: () -> Unit
) {

    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .padding(
                bottom = 6.dp,
                top = 6.dp,
            )
            .fillMaxWidth(),

        elevation = 8.dp,
    ) {
        Column {

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
                    style = MaterialTheme.typography.h5
                )


                // TODO add votes:
/*
                Text(
                    text = "Votes: ",
                    modifier = Modifier
                        .fillMaxWidth(0.85f)
                        .wrapContentWidth(Alignment.CenterHorizontally),
                    style = MaterialTheme.typography.h5
                )
*/
                Text(
                    text = topicVote.vote.toString(),
                    modifier = Modifier
                        .fillMaxWidth(0.85f)
                        .wrapContentWidth(Alignment.End),
                    style = MaterialTheme.typography.h5
                )
            }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp, bottom = 12.dp, start = 8.dp, end = 8.dp)
                ) {

                    ButtonVote(onTopicVoteIndexChanged = onTopicVoteIndexChanged, onVote = onVote)
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp, bottom = 12.dp, start = 8.dp, end = 8.dp)
                ) {
                    ButtonUnVote(
                        onTopicVoteIndexChanged = onTopicVoteIndexChanged,
                        onUnVote = onUnVote
                    )
                }

            }
        }


}