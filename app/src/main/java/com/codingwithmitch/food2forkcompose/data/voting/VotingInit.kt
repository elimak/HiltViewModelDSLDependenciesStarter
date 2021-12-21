package com.codingwithmitch.food2forkcompose.data.voting

import com.codingwithmitch.food2forkcompose.data.topic.Topic
import com.codingwithmitch.food2forkcompose.data.topic.TopicsDataSource
import com.example.voting.voting.VotingConstants.initialVotes
import com.example.voting.voting.VotingLimitsState
import com.example.voting.voting.VotingState



object VotingInit {

    init {
        val topics :MutableList<Topic> = TopicsDataSource().data()
        VotingState.topicVotes = TopicConverterToTopicVote(topics).convertToTopicVotes()

        VotingLimitsState.votingPointsLeft = initialVotes
    }

}