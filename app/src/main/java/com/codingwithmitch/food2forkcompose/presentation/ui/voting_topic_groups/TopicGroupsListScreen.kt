package com.codingwithmitch.food2forkcompose.presentation.ui.voting_topic_groups

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import com.codingwithmitch.food2forkcompose.presentation.components.AppBar
import com.codingwithmitch.food2forkcompose.presentation.theme.AppTheme
import com.codingwithmitch.food2forkcompose.presentation.ui.getAllMenus
import com.codingwithmitch.food2forkcompose.presentation.ui.voting_list.VotingTopicsList
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalComposeUiApi
@ExperimentalCoroutinesApi
@ExperimentalMaterialApi
@Composable
fun TopicGroupsListScreen(viewModel: TopicGroupsListViewModel,
                          isDarkTheme: Boolean,
                          onToggleTheme: () -> Unit){

    val topicGroupsState  = viewModel.topicGroupsState.value

    val scaffoldState = rememberScaffoldState()

    AppTheme(

        scaffoldState = scaffoldState,
        darkTheme = isDarkTheme,

        ) {
        Scaffold(

            topBar = {
                AppBar(
                    menuCategories = getAllMenus(),
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
            TopicGroupsList(
                viewModel = viewModel)
        }
    }


}

