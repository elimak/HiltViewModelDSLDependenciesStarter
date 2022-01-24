package com.codingwithmitch.food2forkcompose.presentation.ui.voting_list

import android.util.Log
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.ExperimentalComposeUiApi
import com.codingwithmitch.food2forkcompose.presentation.components.AppBar
import com.codingwithmitch.food2forkcompose.presentation.theme.AppTheme
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch

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

            topBar = {
                AppBar(

                    /*categories = getAllFoodCategories(),
                    selectedCategory = selectedCategory,
                    onSelectedCategoryChanged = viewModel::onSelectedCategoryChanged,*/
                    onToggleTheme = { onToggleTheme() }
                )
            },
            scaffoldState = scaffoldState,
            snackbarHost = {
                scaffoldState.snackbarHostState
            },
        ) {

            val coroutineScope = rememberCoroutineScope()
            VotingTopicsList(
                viewModel = viewModel,
                onVoteSnackBar = {
                    coroutineScope.launch {
                        scaffoldState.snackbarHostState.showSnackbar(message = "+")
                    }
                },
                onUnVoteSnackBar = {
                    coroutineScope.launch {
                        scaffoldState.snackbarHostState.showSnackbar(message = "-")
                    }
                }

            )
        }
    }
}