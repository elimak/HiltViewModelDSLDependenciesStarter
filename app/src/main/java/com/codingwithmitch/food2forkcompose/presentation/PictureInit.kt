package com.codingwithmitch.food2forkcompose.presentation

import com.codingwithmitch.food2forkcompose.PictureDataSource

object PictureInit {
    init {
        val pictures :MutableList<Picture> = PictureDataSource().data()
        PicturesState.pictures = pictures
    }
}