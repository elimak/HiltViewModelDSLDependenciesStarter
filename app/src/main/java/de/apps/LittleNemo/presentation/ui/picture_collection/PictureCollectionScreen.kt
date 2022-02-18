package de.apps.LittleNemo.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import de.apps.LittleNemo.presentation.ui.picture_collection.PictureCollectionViewModel
import com.google.accompanist.coil.CoilImage
import de.apps.LittleNemo.presentation.components.AppBarCustom
import de.apps.LittleNemo.presentation.theme.AppTheme
import de.apps.LittleNemo.presentation.ui.getAllMenus1
import de.apps.LittleNemo.presentation.ui.picture_collection.PictureCollection
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch




@ExperimentalComposeUiApi
@ExperimentalCoroutinesApi
@ExperimentalMaterialApi
@Composable
fun PictureCollectionScreen(
    viewModel: PictureCollectionViewModel,
    share: () -> Unit,
    isDarkTheme: Boolean,
    onToggleTheme: () -> Unit

){
    val currentPictureIndex = viewModel.currentPictureIndex.value
    val picturesState  = viewModel.picturesState.value

    // TODO DELETE LATER
    val recipes = viewModel.recipes.value
    val selectedCategory = viewModel.selectedCategory.value
    val loading = viewModel.loading.value

    val scaffoldState = rememberScaffoldState()

    AppTheme(
        displayProgressBar = loading,
        scaffoldState = scaffoldState,
        darkTheme = isDarkTheme,

        ) {
        Scaffold(

            topBar = {
                AppBarCustom(
                    menuCategories = getAllMenus1(),
                    selectedCategory = selectedCategory,
                    onSelectedCategoryChanged = viewModel::onSelectedCategoryChanged,
                    onToggleTheme = { onToggleTheme() }
                )
            },
            scaffoldState = scaffoldState,
            snackbarHost = {
                scaffoldState.snackbarHostState
            },
        ) {

            val coroutineScope = rememberCoroutineScope()
            PictureCollection(
                loading = loading,
                viewModel = viewModel,
                share = {share()},//share,
                // TODO CHANGE NAMING LATER  onVote // also delete if no snackbar is needed
                /*onVoteSnackBar = {
                    coroutineScope.launch {
                        scaffoldState.snackbarHostState.showSnackbar(message = "+")
                    }
                },
                onUnVoteSnackBar = {
                    coroutineScope.launch {
                        scaffoldState.snackbarHostState.showSnackbar(message = "-")
                    }
                }*/

            )
        }
    }
}


