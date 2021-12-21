package com.example.composelist

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
import com.example.votingapp.voting_list.VotingTopicsListViewModel

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


        // todo id  dazu //
        var topics:  MutableList<TopicVote> = mutableListOf()
        topics.add(TopicVote(0,"a",1))
        topics.add(TopicVote(1,"b",1))
        topics.add(TopicVote(2,"c",1))


        /*
        if (loading && topics.isEmpty()) {
            LoadingRecipeListShimmer(imageHeight = 250.dp,)
        }
        else if(topics.isEmpty()){
            NothingHere()
        }
        else {*/
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
                        }
                    )
                }
            }
        }
    //}
}


/// TODO PUT TO COMPonents
@Composable
fun VoteCard(topicVote: TopicVote, onClick: () -> Unit) {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .padding(
                bottom = 6.dp,
                top = 6.dp,
            )
            .fillMaxWidth()
            .clickable(onClick = onClick),
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
        }
    }

}
