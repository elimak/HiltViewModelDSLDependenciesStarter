package com.codingwithmitch.food2forkcompose.presentationNew

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.HiltViewModelFactory
import androidx.navigation.NavType
import androidx.navigation.compose.*
import com.codingwithmitch.food2forkcompose.presentationNew.navigation.Screen
import com.codingwithmitch.food2forkcompose.presentationNew.Greeting1
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@ExperimentalMaterialApi
@AndroidEntryPoint
class MainActivity : AppCompatActivity(){

  //@Inject
  //lateinit var connectivityManager: ConnectivityManager

  //@Inject
  //lateinit var settingsDataStore: SettingsDataStore

  override fun onStart() {
    super.onStart()
    //connectivityManager.registerConnectionObserver(this)
  }

  override fun onDestroy() {
    super.onDestroy()
    //connectivityManager.unregisterConnectionObserver(this)
  }

  @ExperimentalComposeUiApi
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      val navController = rememberNavController()
        NavHost(navController = navController, startDestination = Screen.RecipeList.route) {

      composable(route = Screen.RecipeList.route) { navBackStackEntry ->
            val factory = HiltViewModelFactory(LocalContext.current, navBackStackEntry)
          Greeting1(name = "1111")
          //val viewModel: RecipeListViewModel = viewModel("RecipeListViewModel", factory)

            /*
            RecipeListScreen(
              isDarkTheme = settingsDataStore.isDark.value,
              isNetworkAvailable = connectivityManager.isNetworkAvailable.value,
              onToggleTheme = settingsDataStore::toggleTheme,
              onNavigateToRecipeDetailScreen = navController::navigate,
              viewModel = viewModel,
            )

             */
          }
          composable(
            route = Screen.RecipeDetail.route + "/{recipeId}",
            arguments = listOf(navArgument("recipeId") {
              type = NavType.IntType
            })
          ) { navBackStackEntry ->
            val factory = HiltViewModelFactory(LocalContext.current, navBackStackEntry)
            Greeting1(name = "2222")
            //val viewModel: RecipeViewModel = viewModel("RecipeDetailViewModel", factory)
            /*
            RecipeDetailScreen(
              isDarkTheme = settingsDataStore.isDark.value,
              isNetworkAvailable = connectivityManager.isNetworkAvailable.value,
              recipeId = navBackStackEntry.arguments?.getInt("recipeId"),
              viewModel = viewModel,
            )

             */
          }
        }

    }
  }


}














