package de.apps.LittleNemo.presentation.ui


import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
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


}