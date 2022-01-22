package com.codingwithmitch.food2forkcompose.presentation.ui.voting_list

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import com.codingwithmitch.food2forkcompose.presentation.theme.AppTheme
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalComposeUiApi
@ExperimentalCoroutinesApi
@ExperimentalMaterialApi
@Composable
fun VotingTopicsListScreen(
    viewModel: VotingTopicsListViewModel,
    isDarkTheme: Boolean,
    onToggleTheme: () -> Unit,


){
    val topicVoteState  = viewModel.topicVoteState.value
    var topicVoteStateChanged  = viewModel.topicVoteStateChanged.value // TODO it is just a boolean to redraw the composable --> changes in just topicvotestate wont cause a redraw of this composable
    var topicVoteIndex = viewModel.topicVoteIndex
    val scaffoldState = rememberScaffoldState()

    AppTheme(

        scaffoldState = scaffoldState,
        darkTheme = isDarkTheme,

    ) {
        Scaffold(

            /*topBar = {
                SearchAppBar(
                    query = query,
                    onQueryChanged = viewModel::onQueryChanged,
                    onExecuteSearch = {
                        viewModel.onTriggerEvent(RecipeListEvent.NewSearchEvent)
                    },
                    categories = getAllFoodCategories(),
                    selectedCategory = selectedCategory,
                    onSelectedCategoryChanged = viewModel::onSelectedCategoryChanged,
                    onToggleTheme = { onToggleTheme() }
                )
            },*/
            scaffoldState = scaffoldState,
            snackbarHost = {
                scaffoldState.snackbarHostState
            },
        ) {
            VotingTopicsList(
                viewModel
            )
        }
    }
}