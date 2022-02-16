package de.apps.LittleNemo.presentation.ui


import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import de.apps.LittleNemo.presentation.Picture
import de.apps.LittleNemo.presentation.PicturesState

import dagger.hilt.android.lifecycle.HiltViewModel
import de.apps.LittleNemo.interactors.picture_collection.SearchPictureCollection
import javax.inject.Inject




@HiltViewModel
class PictureCollectionViewModel
@Inject
constructor(
    private val searchPictureCollection: SearchPictureCollection

) : ViewModel() {

    val currentPictureIndex = mutableStateOf(0)
    val picturesState: MutableState<List<Picture>> = mutableStateOf(ArrayList())

    init {
        picturesState.value = PicturesState.pictures
        loadRecipes()
    }


    ///////
    private fun loadRecipes(){
        searchPictureCollection.execute(
            page = 1,
            query = ""
        )
            /*
            .collectCommon(viewModelScope) { dataState ->
            state.value = state.value.copy(isLoading = dataState.isLoading)

            dataState.data?.let { recipes ->
                appendRecipes(recipes)
            }

            dataState.message?.let { message ->
                appendToMessageQueue(message)
            }
        }*/
    }



    ///////

    fun nextPicture(){
        currentPictureIndex.value++
    }
    fun previousPicture(){
        currentPictureIndex.value--
    }


    /////////
    /*
    fun share() {
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, "This is my text to send.")
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)
    }
    */

    ///////

}