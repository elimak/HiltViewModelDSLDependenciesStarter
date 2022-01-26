package com.codingwithmitch.food2forkcompose.presentation.ui.voting_topic_groups

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.codingwithmitch.food2forkcompose.data.topicGroup.TopicGroup
import com.codingwithmitch.food2forkcompose.data.topicGroup.TopicGroupsState
import com.codingwithmitch.food2forkcompose.data.voting.TopicVote
import com.codingwithmitch.food2forkcompose.modules.voting.VotingState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class TopicGroupsListViewModel
    @Inject
    constructor(
        //private val updateList: UpdateList // injecting test todo delete
    ): ViewModel(){

    val topicGroupsState: MutableState<List<TopicGroup>> = mutableStateOf(ArrayList())


    init {
        topicGroupsState.value = TopicGroupsState.topicGroupes
    }


    }

