package com.codingwithmitch.food2forkcompose.data.topicGroup

import com.codingwithmitch.food2forkcompose.data.topic.Topic

data class TopicGroup(
    val name:String,
    val topics:MutableList<Topic>
)
