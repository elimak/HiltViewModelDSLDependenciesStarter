package de.apps.LittleNemo.presentation.ui


import android.content.Intent
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.ViewModel
import de.apps.LittleNemo.presentation.Picture
import de.apps.LittleNemo.presentation.PicturesState

import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject




@HiltViewModel
class PictureCollectionViewModel
@Inject
constructor(


) : ViewModel() {

    val currentPictureIndex = mutableStateOf(0)
    val picturesState: MutableState<List<Picture>> = mutableStateOf(ArrayList())

    init {
        picturesState.value = PicturesState.pictures
    }


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