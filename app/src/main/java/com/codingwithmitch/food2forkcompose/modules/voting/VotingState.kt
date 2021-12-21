package com.example.voting.voting

object VotingState {
    lateinit var topicVotes : MutableList<TopicVote>

    /*
    init {
        val topics :MutableList<Topic> = Topics().invoke() // todo pass this to constructor // have a datasource !!
        topicVotes  = TopicConverterToTopicVote(topics).convertToTopicVotes()
    }
    */

}