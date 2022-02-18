package de.apps.LittleNemo.presentation.ui.picture_collection

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import de.apps.LittleNemo.domain.model.Recipe
import de.apps.LittleNemo.presentation.Picture
import de.apps.LittleNemo.presentation.components.*


// TODO RENAME IN PICTURE COLLECTION LOADER
@Composable
fun PictureCollection(
    loading: Boolean,
    // TODO VIEWMODEL out --> just pictureState and index
    viewModel: PictureCollectionViewModel,
    share: () -> Unit) {

    /// TODO move to screen
    val currentPictureIndex = viewModel.currentPictureIndex.value
    val picturesState = viewModel.picturesState.value
    // TODO DELETE LATER
    val recipes = viewModel.recipes.value


    Box(
        modifier = Modifier
            .background(color = MaterialTheme.colors.surface)
    ) {
        if (loading && recipes.isEmpty()) {
            LoadingRecipeListShimmer(imageHeight = 250.dp,)
        } else if (recipes.isEmpty()) {
            NothingHere()
        } else {
// TODO RENAME
            ContentRename(
                share = { share() },
                picturesState = picturesState,
                currentPictureIndex = currentPictureIndex,
                viewModel = viewModel,
                        recipes = recipes
            )
        }

    }

}



// TODO RENAME
@Composable
fun ContentRename(
    share: () -> Unit,
    picturesState:List<Picture>,
    currentPictureIndex:Int,
    // TODO get viewmodel out -- just funktion passing -- after firrst pass use functions to pass
    viewModel: PictureCollectionViewModel,
    recipes:List<Recipe>
    ) {

    var recipeTi = recipes[0].title
    Text(text = "$recipeTi")

    //Image(data = pictureData)
    var pictureData = picturesState[currentPictureIndex].link
    Image(data = pictureData)

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom
    ) {


        var pictureName = picturesState[currentPictureIndex].link
        //Text(text = "$pictureName")
        // --- BUG HERE?? var textFromRecipe = recipes[0].title
        //--BUG HERE?? Text(text = "$textFromRecipe")

        // TEST null
        //var textFromRecipe:String? = null
        //Text(text = "$textFromRecipe")


        ButtonShare(share = share)

        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.onPrimary)
                .padding(10.dp)
        ) {


            if (currentPictureIndex !== 0) {
                ButtonNext(viewModel = viewModel)
            }
            if (currentPictureIndex < picturesState.size - 1) {
                ButtonPrev(viewModel = viewModel)
            }
        }
    }
}






