package de.apps.LittleNemo.presentation.ui.picture_collection


import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import de.apps.LittleNemo.presentation.Picture
import de.apps.LittleNemo.presentation.PicturesState

import dagger.hilt.android.lifecycle.HiltViewModel
import de.apps.LittleNemo.domain.model.Recipe
import de.apps.LittleNemo.interactors.picture_collection.SearchPictureCollection
import de.apps.LittleNemo.presentation.ui.MenuCategory1
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject




@HiltViewModel
class PictureCollectionViewModel
@Inject
constructor(
    private val searchPictureCollection: SearchPictureCollection

) : ViewModel() {

    val currentPictureIndex = mutableStateOf(0)
    val picturesState: MutableState<List<Picture>> = mutableStateOf(ArrayList())
    val loading = mutableStateOf(false)

    // TODO CHANGE NAME/delete LATER
    val recipes: MutableState<List<Recipe>> = mutableStateOf(ArrayList())

    val selectedCategory: MutableState<MenuCategory1?> = mutableStateOf(null)
    init {
        picturesState.value = PicturesState.pictures
        //loadRecipes() // TODO add later !!
    }



    fun onTriggerEvent(){//event: RecipeListEvent){
       /* viewModelScope.launch {
            try {
                loadPictureCollection()

            }catch (e: Exception){
                //Log.e(TAG, "launchJob: Exception: ${e}, ${e.cause}")
                e.printStackTrace()
            }
            finally {
                //Log.d(TAG, "launchJob: finally called.")
            }
        }*/
    }



    private fun loadPictureCollection(){
        searchPictureCollection.execute(page = 1, query = "").onEach { dataState ->
            loading.value = dataState.loading



            dataState.data?.let { list ->
                recipes.value = list
            }
/*
            dataState.error?.let { error ->
                Log.e(TAG, "newSearch: ${error}")
                dialogQueue.appendErrorMessage("An Error Occurred", error)
            }

             */
        }.launchIn(viewModelScope)


        /*
        searchPictureCollection.execute(
            page = 1,
            query = ""
        )
        */
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