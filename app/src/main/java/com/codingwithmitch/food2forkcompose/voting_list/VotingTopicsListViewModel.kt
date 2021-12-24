package com.codingwithmitch.food2forkcompose.voting_list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.codingwithmitch.food2forkcompose.data.voting.TopicVote
import com.codingwithmitch.food2forkcompose.modules.voting.VotingState

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

    //val topicVoteState: State<List<TopicVote>> = mutableStateOf(ArrayList())

    //val recipe: MutableState<Recipe?> = mutableStateOf(null)

          //--->var topicVoteState: List<TopicVote> = mutableStateOf(ArrayList())
              //  val loading = mutableStateOf(false)



                   val topicVoteState: MutableState<List<TopicVote>> = mutableStateOf(ArrayList())

    var topics = mutableListOf(0,100)
    //var count  = mutableStateOf(0)


    //var count:MutableState<MutableList<Int>>  = mutableStateOf(topics)
    var count = mutableStateListOf(topics)

    //val recipes: MutableState<List<Recipe>> = mutableStateOf(ArrayList())


    init {
        /*
        var topics:  MutableList<TopicVote> = mutableListOf()
        topics.add(TopicVote(0,"a",1))
        topics.add(TopicVote(1,"b",1))
        topics.add(TopicVote(2,"c",1))

        loading.value = true

        //topicVoteState.value = topics//
         */
        topicVoteState.value = VotingState.topicVotes // TODO
        onTriggerEvent()
    }

    // todo add events for usecases
    //fun onTriggerEvent(event: TopicVoteListEvent){
    fun onTriggerEvent(){
        newUpdateList()
        //count.value++


        count[1] = (count[1] +1) as MutableList<Int>
        /*
        var topics = mutableListOf(count.value[0],count.value[1])
        count.value = topics
    */
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



