package com.codingwithmitch.food2forkcompose.data.topicGroup

import com.codingwithmitch.food2forkcompose.data.topic.Topic

class TopicGroupDataSource {

    fun retrievData():MutableList<TopicGroup>{
        var topics1 : MutableList<Topic> = mutableListOf()
        topics1.add(Topic("Thema 1"))
        topics1.add(Topic("Thema 2"))
        topics1.add(Topic("Thema 3"))
        topics1.add(Topic("Thema 4"))

        var topicGroups : MutableList<TopicGroup> = mutableListOf()
       val topicGroup1:TopicGroup = TopicGroup("name1",topics1)
        topicGroups.add(topicGroup1)
        return topicGroups
    }

}