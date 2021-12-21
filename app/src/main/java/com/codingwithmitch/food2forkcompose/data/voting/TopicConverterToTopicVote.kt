package com.codingwithmitch.food2forkcompose.data.voting

import com.codingwithmitch.food2forkcompose.data.topic.Topic

class TopicConverterToTopicVote(private val topics: MutableList<Topic>) { // TODO adapter???


    fun convertToTopicVotes():MutableList<TopicVote>{  // TODO invoke    /// using map !!!!!!
        var topicVotes : MutableList<TopicVote> =   mutableListOf()
        // TODO  loop not hardcoded
        topicVotes.add(topicToTopicVote(0,topics[0]))
        topicVotes.add(topicToTopicVote(1,topics[1]))
        return topicVotes
    }

    fun topicToTopicVote(id:Int,topic: Topic, vote:Int=0): TopicVote {
        val topicVote = TopicVote(id,topic.text,vote)
        return topicVote
    }

}