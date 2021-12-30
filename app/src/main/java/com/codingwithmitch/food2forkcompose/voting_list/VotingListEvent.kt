package com.codingwithmitch.food2forkcompose.voting_list

sealed class VotingListEvent
 {

    object VoteEvent : VotingListEvent()

    object UnVoteEvent : VotingListEvent()


}
