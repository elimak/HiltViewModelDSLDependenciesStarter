package com.codingwithmitch.food2forkcompose.modules.voting


import org.junit.Test

import org.junit.Assert.*

/**

 */

// TODO just 1 assert per test is better?
class VotingTests {



    private val initialVotingPointsLeft = 1
    private val initialVoteOnTopicA = 1


    private  var topics : MutableList<TopicVote> = mutableListOf()

    // TODO add teardown
    // TODO REPLACE with BeforeEach
    //@BeforeEach
    fun setup() {

        topics  = mutableListOf()
        topics.add(TopicVote(0,"a",initialVoteOnTopicA))
        VotingState.topicVotes = topics

        VotingLimitsState.votingPointsLeft = initialVotingPointsLeft
    }




    @Test
    fun tryVoteIncrease_notWorking_noVotesLeft()
    {

        setup()
        assertEquals(VotingLimitsState.votingPointsLeft, initialVotingPointsLeft)
        assertEquals(VotingState.topicVotes[0].vote, initialVoteOnTopicA)

        // -----> 2 * vote
        Voting.vote(VotingState.topicVotes[0])
        Voting.vote(VotingState.topicVotes[0])

        // but just 1 one vote has been placed -> because initialVotingPointsLeft was only 1
        assertEquals(VotingLimitsState.votingPointsLeft, initialVotingPointsLeft-1)
        assertEquals(VotingState.topicVotes[0].vote, initialVoteOnTopicA+1)

        // 2 votes can  not be placed - no left voting points
        assertNotEquals(VotingLimitsState.votingPointsLeft, initialVotingPointsLeft-2)
        assertNotEquals(VotingState.topicVotes[0].vote, initialVoteOnTopicA+2)
    }

    @Test
    fun tryVoteDecrease_notWorking_topicVoteAlreadyAt0MinVotes(){

        setup()
        assertEquals(VotingLimitsState.votingPointsLeft, initialVotingPointsLeft)
        assertEquals(VotingState.topicVotes[0].vote, initialVoteOnTopicA)

        // ----> 2 * devote
        Voting.deVote(VotingState.topicVotes[0])
        Voting.deVote(VotingState.topicVotes[0])

        // but just 1 one devote has been placed -> because initialVoteOnTopicA was only 1
        assertEquals(VotingLimitsState.votingPointsLeft, initialVotingPointsLeft+1)
        assertEquals(VotingState.topicVotes[0].vote, initialVoteOnTopicA-1)

        // 2 devotes can  not be placed on topicA
        assertNotEquals(VotingLimitsState.votingPointsLeft, initialVotingPointsLeft+2)
        assertNotEquals(VotingState.topicVotes[0].vote, initialVoteOnTopicA-2)
    }




    @Test
    fun voteIncreased_votingPointsLeftDecreasedAndVoteOnTopicIncreased () {

        setup()
        assertEquals(VotingLimitsState.votingPointsLeft, initialVotingPointsLeft)
        assertEquals(VotingState.topicVotes[0].vote, initialVoteOnTopicA)

        // -----> vote
        Voting.vote(VotingState.topicVotes[0])

        assertEquals(VotingLimitsState.votingPointsLeft, initialVotingPointsLeft-1)
        assertEquals(VotingState.topicVotes[0].vote, initialVoteOnTopicA+1)

    }

    @Test
    fun voteDecreased_votingPointsLeftIncreasedAndVoteOnTopicDecreased () {

        setup()
        assertEquals(VotingLimitsState.votingPointsLeft, initialVotingPointsLeft)
        assertEquals(VotingState.topicVotes[0].vote, initialVoteOnTopicA)

        // ----> devote
        Voting.deVote(VotingState.topicVotes[0])

        assertEquals(VotingLimitsState.votingPointsLeft, initialVotingPointsLeft+1)
        assertEquals(VotingState.topicVotes[0].vote, initialVoteOnTopicA-1)

    }








}