package com.codingwithmitch.food2forkcompose.data.voting

import com.codingwithmitch.food2forkcompose.data.topic.Topic
import com.codingwithmitch.food2forkcompose.data.topic.TopicsDataSource
import com.codingwithmitch.food2forkcompose.modules.voting.VotingConstants.initialVotes
import com.codingwithmitch.food2forkcompose.modules.voting.VotingLimitsState
import com.codingwithmitch.food2forkcompose.modules.voting.VotingState


object VotingInit {

    init {
        val topics :MutableList<Topic> = TopicsDataSource().data()
        VotingState.topicVotes = TopicConverterToTopicVote(topics).convertToTopicVotes()

        VotingLimitsState.votingPointsLeft = initialVotes
    }

}