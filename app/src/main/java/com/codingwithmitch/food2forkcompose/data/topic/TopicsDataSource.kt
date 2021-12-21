package com.codingwithmitch.food2forkcompose.data.topic

import com.codingwithmitch.food2forkcompose.data.topic.Topic

class TopicsDataSource {



    fun data():MutableList<Topic>{
        var topics : MutableList<Topic> = mutableListOf()
        topics.add(Topic("1111aaa"))
        topics.add(Topic("22222bb"))
        return topics
    }
}