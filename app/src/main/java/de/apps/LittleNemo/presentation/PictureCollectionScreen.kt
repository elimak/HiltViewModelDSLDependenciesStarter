package de.apps.LittleNemo.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import de.apps.LittleNemo.presentation.ui.PictureCollectionViewModel
import com.google.accompanist.coil.CoilImage






@Composable
fun PictureCollectionScreen(viewModel: PictureCollectionViewModel, share: () -> Unit) {
    val currentPictureIndex = viewModel.currentPictureIndex.value
    val picturesState  = viewModel.picturesState.value
    // TODO DELETE LATER
    val recipes = viewModel.recipes.value

    var pictureData = picturesState[currentPictureIndex].link
    Image(data = pictureData)

    Column (modifier = Modifier.fillMaxSize(),
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


            if(currentPictureIndex !==0) {
                ButtonNext( viewModel= viewModel)
            }
            if(currentPictureIndex < picturesState.size-1){
                ButtonPrev( viewModel= viewModel)
        }
        }
    }
}



@Composable
fun Image(data:String){
    CoilImage(
        data = data,
        contentDescription = "",
        modifier = Modifier
            .fillMaxWidth()
            .height(225.dp),
        contentScale = ContentScale.Crop,)
}


@Composable
fun ButtonShare( share: () -> Unit) {
    Button(
        modifier = Modifier.padding(end = 8.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.onSecondary),
        onClick = { share() },

        ) {
        Text(text = "share")
    }
}

@Composable
fun ButtonNext( viewModel: PictureCollectionViewModel) {
    Button(
        modifier = Modifier.padding(end = 8.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.onSecondary),
        onClick = { viewModel.previousPicture() },


    ) {
        Text(text = "next")
    }
}
@Composable
fun ButtonPrev( viewModel: PictureCollectionViewModel) {
    Button(
        modifier = Modifier.padding(end = 8.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.onSecondary),
        //onClick = { viewModel.nextPicture() }
        onClick = { viewModel.onTriggerEvent() } // TODO TESTING
    ) {
        Text(text = "prev")
    }
}

