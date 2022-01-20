package com.codingwithmitch.food2forkcompose.data.topic


class TopicsDataSource {



    fun data():MutableList<Topic>{
        var topics : MutableList<Topic> = mutableListOf()
        topics.add(Topic("Thema 1"))
        topics.add(Topic("Thema 2"))
        topics.add(Topic("Thema 3"))
        topics.add(Topic("Thema 4"))

        return topics
    }
}