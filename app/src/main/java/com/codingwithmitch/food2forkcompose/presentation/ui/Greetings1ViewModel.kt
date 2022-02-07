package com.codingwithmitch.food2forkcompose.presentation.ui


import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject




@HiltViewModel
class Greetings1ViewModel
@Inject
constructor(

    //private val connectivityManager: ConnectivityManager,

) : ViewModel() {

    fun changeQuerry(){
        query.value = "fsfgggg"
    }
    val query = mutableStateOf("123u")

}