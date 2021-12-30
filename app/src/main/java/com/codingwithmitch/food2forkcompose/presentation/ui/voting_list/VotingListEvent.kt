package com.codingwithmitch.food2forkcompose.presentation.ui.voting_list

sealed class VotingListEvent
 {

    object VoteEvent : VotingListEvent()

    object UnVoteEvent : VotingListEvent()


}
