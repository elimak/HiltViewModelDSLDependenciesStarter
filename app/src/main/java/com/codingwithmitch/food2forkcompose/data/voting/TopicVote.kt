package com.codingwithmitch.food2forkcompose.data.voting

// TODO topicVote is in both modules (app module and vote module) --> is it good? --> not anymore just once - but it would be needed in Vote Module later
data class TopicVote(val id:Int, val text:String, var vote:Int)



