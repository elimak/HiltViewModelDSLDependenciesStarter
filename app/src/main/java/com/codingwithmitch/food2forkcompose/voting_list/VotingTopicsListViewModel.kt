package com.example.votingapp.voting_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.voting.voting.TopicVote
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

//@AndroidEntryPoint // TODO NEEDED??
@HiltViewModel
    class VotingTopicsListViewModel
    @Inject
    constructor(
        //TODO private val updateList: UpdateList
    )
     : ViewModel(){




/*
    @HiltViewModel
    class RecipeListViewModel
    @Inject
    constructor(
        private val searchRecipes: SearchRecipes,
        private val restoreRecipes: RestoreRecipes,
        private val connectivityManager: ConnectivityManager,
        private @Named("auth_token") val token: String,
        private val savedStateHandle: SavedStateHandle,
    ) : ViewModel() {
*/






        // TODO have private _topicVoteState
    //private val _topicVoteState: MutableState<List<TopicVote>> = mutableStateOf(ArrayList())
    //val topicVoteState: State<List<TopicVote>> = _topicVoteState
    val topicVoteState: State<List<TopicVote>> = mutableStateOf(ArrayList())


    init {
        onTriggerEvent()
    }

    // todo add events for usecases
    //fun onTriggerEvent(event: TopicVoteListEvent){
    fun onTriggerEvent(){
        newUpdateList()
    }


    private fun newUpdateList(){
        //---updateList.execute()
    }


    // TODO DELETE
    fun updateText() {
      //_state.value = state.value.copy(text = "dd")
         /*
        _state.value = state.value.copy(
                    isOrderSectionVisible = !state.value.isOrderSectionVisible
                )
        */
    }


}



