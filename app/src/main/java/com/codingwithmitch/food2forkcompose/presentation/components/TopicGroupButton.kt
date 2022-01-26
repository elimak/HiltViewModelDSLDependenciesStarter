package com.codingwithmitch.food2forkcompose.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.codingwithmitch.food2forkcompose.data.topicGroup.TopicGroup

@Composable
fun TopicGroupButton(topicGroup:TopicGroup){
    Text(
        text = topicGroup.name,
        modifier = Modifier
            .fillMaxWidth(0.85f)
            .wrapContentWidth(Alignment.Start),
        style = MaterialTheme.typography.h5
    )
}