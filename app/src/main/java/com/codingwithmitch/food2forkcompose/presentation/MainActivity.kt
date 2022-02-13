package com.codingwithmitch.food2forkcompose.presentation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.HiltViewModelFactory
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.*
import com.codingwithmitch.food2forkcompose.presentation.navigation.Screen
import com.codingwithmitch.food2forkcompose.presentation.ui.Greetings1ViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@ExperimentalMaterialApi
@AndroidEntryPoint
class MainActivity : AppCompatActivity(){



  @ExperimentalComposeUiApi
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
      PictureInit

      setContent {
      val navController = rememberNavController()
        NavHost(navController = navController, startDestination = Screen.RecipeList.route) {

      composable(route = Screen.RecipeList.route) { navBackStackEntry ->
            val factory = HiltViewModelFactory(LocalContext.current, navBackStackEntry)

          val viewModel: Greetings1ViewModel = viewModel("RecipeListViewModel", factory)
          PictureCollectionScreen(viewModel = viewModel)

          }
          composable(
            route = Screen.RecipeDetail.route + "/{recipeId}",
            arguments = listOf(navArgument("recipeId") {
              type = NavType.IntType
            })
          ) { navBackStackEntry ->
            val factory = HiltViewModelFactory(LocalContext.current, navBackStackEntry)
            Greeting2(name = "2222")

          }
        }

    }
  }


}














