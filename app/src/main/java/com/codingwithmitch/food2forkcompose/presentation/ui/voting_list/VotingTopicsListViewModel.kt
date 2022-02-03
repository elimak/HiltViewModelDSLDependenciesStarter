package com.codingwithmitch.food2forkcompose.presentation.ui.voting_list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.codingwithmitch.food2forkcompose.data.voting.TopicVote
import com.codingwithmitch.food2forkcompose.modules.voting.Voting
import com.codingwithmitch.food2forkcompose.modules.voting.VotingState
import com.codingwithmitch.food2forkcompose.presentation.ui.MenuCategory1
import com.codingwithmitch.food2forkcompose.presentation.ui.getMenuCategory1

import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
    class VotingTopicsListViewModel
    @Inject
    constructor(
        //private val updateList: UpdateList // injecting test todo delete
    )
     : ViewModel(){

    val selectedCategory: MutableState<MenuCategory1?> = mutableStateOf(null)

    val topicVoteState: MutableState<List<TopicVote>> = mutableStateOf(ArrayList())
    var topicVoteStateChanged:MutableState<Boolean> = mutableStateOf(false)
    val topicVoteIndex = mutableStateOf(0)



    init {
        topicVoteState.value = VotingState.topicVotes
    }


    fun onSelectedCategoryChanged(category:String){
        val newCategory = getMenuCategory1(category)
        setSelectedCategory(newCategory)
    }

    private fun setSelectedCategory(category: MenuCategory1?){
        selectedCategory.value = category

    }


    fun onTriggerEvent(event: VotingListEvent){
        when(event){
            is VotingListEvent.VoteEvent -> {
                vote()
            }
            is VotingListEvent.UnVoteEvent -> {
                unVote()
            }
        }
    }

    private fun vote(){
        topicVoteStateChanged.value = !topicVoteStateChanged.value // TODO not optimal but needed to cause a composable redraw as topicVoteSTate does not cause a redrwa
        Voting.vote(topicVoteState.value[topicVoteIndex.value])
    }
    private fun unVote(){
        topicVoteStateChanged.value = !topicVoteStateChanged.value // TODO not optimal but needed to cause a composable redraw as topicVoteSTate does not cause a redrwa
        Voting.deVote(topicVoteState.value[topicVoteIndex.value])
    }

    fun onTopicVoteIndexChanged(index: Int) {
        setTopicVoteIndex(index)
    }
    private fun setTopicVoteIndex(index: Int){
        topicVoteIndex.value = index
    }



}



