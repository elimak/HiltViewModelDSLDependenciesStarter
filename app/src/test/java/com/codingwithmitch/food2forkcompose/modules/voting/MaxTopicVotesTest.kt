package com.codingwithmitch.food2forkcompose.modules.voting


import org.junit.Assert
import org.junit.Test
// TODO just 1 assert per test is better?
class MaxTopicVotesTest {

    private val initialVotingPointsLeft = 10
    private val initialVoteOnTopicA = 99





    private  var topics : MutableList<TopicVote> = mutableListOf()
    // TODO add teardown
    // TODO REPLACE with BeforeEach
    fun setupToTestTopicVotesMax() {
        topics = mutableListOf()
        topics.add(TopicVote(0,"a", initialVoteOnTopicA))
        VotingState.topicVotes = topics

        VotingLimitsState.votingPointsLeft = initialVotingPointsLeft
    }


    @Test
    fun tryVoteIncrease_notWorking_topicVoteAlreadyMaxVotes(){

        setupToTestTopicVotesMax()

        // -----> 2 * vote
        Voting.vote(VotingState.topicVotes[0])
        Voting.vote(VotingState.topicVotes[0])

        // but just 1 one vote has been placed -> because topic vote will be at 100 not 101
        Assert.assertEquals(VotingLimitsState.votingPointsLeft, initialVotingPointsLeft - 1)
        Assert.assertEquals(VotingState.topicVotes[0].vote, initialVoteOnTopicA + 1)

        // 2 votes can  not be placed - not possible to overdo the maximum for a topic vote of 100
        Assert.assertNotEquals(VotingLimitsState.votingPointsLeft, initialVotingPointsLeft - 2)
        Assert.assertNotEquals(VotingState.topicVotes[0].vote, initialVoteOnTopicA + 2)

    }

}