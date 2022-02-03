package com.codingwithmitch.food2forkcompose.presentation.ui.voting_topic_groups

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.codingwithmitch.food2forkcompose.data.topicGroup.TopicGroup
import com.codingwithmitch.food2forkcompose.data.topicGroup.TopicGroupsState
import com.codingwithmitch.food2forkcompose.presentation.ui.MenuCategory1
import com.codingwithmitch.food2forkcompose.presentation.ui.getMenuCategory1
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class TopicGroupsListViewModel
    @Inject
    constructor(
        //private val updateList: UpdateList // injecting test todo delete
    ): ViewModel(){

    val topicGroupsState: MutableState<List<TopicGroup>> = mutableStateOf(ArrayList())
    val selectedCategory: MutableState<MenuCategory1?> = mutableStateOf(null)


    init {
        topicGroupsState.value = TopicGroupsState.topicGroupes
    }

// -----------
    fun onSelectedCategoryChanged(category: String) {
        val newCategory = getMenuCategory1(category)
        setSelectedCategory(newCategory)

    }
    private fun setSelectedCategory(category: MenuCategory1?){
        selectedCategory.value = category
    }




    }

