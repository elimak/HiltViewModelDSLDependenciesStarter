package com.codingwithmitch.food2forkcompose.presentation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.HiltViewModelFactory
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.*
import com.codingwithmitch.food2forkcompose.data.voting.VotingInit
import com.codingwithmitch.food2forkcompose.presentation.navigation.Screen
import com.codingwithmitch.food2forkcompose.presentation.ui.voting_list.VotingTopicsListScreen
import com.codingwithmitch.food2forkcompose.presentation.ui.voting_list.VotingTopicsListViewModel
import com.codingwithmitch.food2forkcompose.presentation.ui.voting_topic_groups.TopicGroupsListScreen
import com.codingwithmitch.food2forkcompose.presentation.ui.voting_topic_groups.TopicGroupsListViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@ExperimentalMaterialApi
@AndroidEntryPoint
class MainActivity : AppCompatActivity(){

  //private var isDark = true
  private var isDark = mutableStateOf(false)


  @ExperimentalComposeUiApi
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

      VotingInit

      setContent {
      val navController = rememberNavController()
        NavHost(navController = navController, startDestination = Screen.RecipeList.route) {

            composable(
              //( TODO change naming Screen.RecipeList
          route = Screen.RecipeList.route) { navBackStackEntry ->
            val factory = HiltViewModelFactory(LocalContext.current, navBackStackEntry)

              // NEW
              val viewModel: TopicGroupsListViewModel = viewModel("TopicGroupsListViewModel", factory)
              TopicGroupsListScreen(viewModel= viewModel,isDarkTheme=isDark.value, onToggleTheme = {isDark.value = !isDark.value})
              // NEW

              // TODO old screen working
            //val viewModel: VotingTopicsListViewModel = viewModel("VotingTopicsListViewModel", factory)
            //VotingTopicsListScreen(viewModel= viewModel,isDarkTheme=isDark.value, onToggleTheme = {isDark.value = !isDark.value})
            }
         // settingsDataStore.isDark.value
          /////////////////////////   // todo just template for next Screen
            composable(
            route = Screen.RecipeDetail.route + "/{recipeId}",
            arguments = listOf(navArgument("recipeId") {
              type = NavType.IntType
            })
          ) { navBackStackEntry ->
            val factory = HiltViewModelFactory(LocalContext.current, navBackStackEntry)

          }
          ////////////////////////////

          
        }

    }
  }


}














