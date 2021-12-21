package com.example.voting.voting

import com.example.voting.voting.VotingConstants.maxVotesPerTopic
import com.example.voting.voting.VotingConstants.minVotes
import com.example.voting.voting.VotingConstants.minVotesPerTopic


// todo does not need to be singelton
object Voting {



    fun vote(topicVote:TopicVote){
        if(VotingLimitsState.votingPointsLeft > minVotes) {
            voteIncrease(topicVote)
        }
    }

    private fun voteIncrease(topicVote:TopicVote){
        if (topicVote.vote < maxVotesPerTopic  ){
            topicVote.vote++
            VotingLimitsState.votingPointsLeft--
        }
    }



    fun deVote(topicVote:TopicVote){
        //if(VotingLimitsState.votingPointsLeft < maxVotes) { // Max votes not needed // it just would be same as initialVotingPoints
            voteDecrease(topicVote)
        //}
    }

    private fun voteDecrease(topicVote:TopicVote){
        if(topicVote.vote > minVotesPerTopic  ){
            topicVote.vote--
            VotingLimitsState.votingPointsLeft++
        }
    }


}