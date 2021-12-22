package com.codingwithmitch.food2forkcompose.voting_list

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
//import androidx.hilt.navigation.compose.hiltViewModel
import com.codingwithmitch.food2forkcompose.data.voting.TopicVote
import com.codingwithmitch.food2forkcompose.presentation.components.VoteCard

@Composable
fun TopicsList(
    viewModelTopics: VotingTopicsListViewModel //= hiltViewModel()
/*
    loading: Boolean,
    recipes: List<Recipe>,
    onChangeScrollPosition: (Int) -> Unit,
    page: Int,
    onTriggerNextPage: () -> Unit,
    onNavigateToRecipeDetailScreen: (String) -> Unit,

     */
){
    val topicVoteState  = viewModelTopics.topicVoteState.value

    Box(modifier = Modifier
        .background(color = MaterialTheme.colors.surface)
    ) {

//////////////
        // todo id  dazu //
        var topics:  List<TopicVote> = topicVoteState
        /*
        var topics:  MutableList<TopicVote> = mutableListOf()
        topics.add(TopicVote(0,"a",1))
        topics.add(TopicVote(1,"b",1))
        topics.add(TopicVote(2,"c",1))

         */
/////////////


            LazyColumn{
                itemsIndexed(
                    items = topics
                ) { index, recipe ->
                    /*
                    onChangeScrollPosition(index)
                    if ((index + 1) >= (page * PAGE_SIZE) && !loading) {
                        onTriggerNextPage()
                    }*/
                    VoteCard(
                        topicVote = recipe,
                        onClick = {
                            // val route = Screen.RecipeDetail.route + "/${recipe.id}"
                            //onNavigateToRecipeDetailScreen(route)
                        },
                        topicVoteState = topicVoteState

                    )


                }
            }
        }

}



