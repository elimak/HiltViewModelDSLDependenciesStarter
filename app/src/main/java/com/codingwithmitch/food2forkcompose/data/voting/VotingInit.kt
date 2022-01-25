package com.codingwithmitch.food2forkcompose.data.voting

import com.codingwithmitch.food2forkcompose.data.topic.Topic
import com.codingwithmitch.food2forkcompose.data.topicGroup.TopicGroup
import com.codingwithmitch.food2forkcompose.data.topicGroup.TopicGroupDataSource
import com.codingwithmitch.food2forkcompose.modules.voting.VotingConstants.initialVotes
import com.codingwithmitch.food2forkcompose.modules.voting.VotingLimitsState
import com.codingwithmitch.food2forkcompose.modules.voting.VotingState


object VotingInit {

    init {
        val topicsGroups: MutableList<TopicGroup> = TopicGroupDataSource().retrievData()
        //val topics :MutableList<Topic> = TopicsDataSource().data()
        val topics :MutableList<Topic> = topicsGroups[0].topics
        VotingState.topicVotes = TopicConverterToTopicVote(topics).convertToTopicVotes()

        VotingLimitsState.votingPointsLeft = initialVotes
    }

}