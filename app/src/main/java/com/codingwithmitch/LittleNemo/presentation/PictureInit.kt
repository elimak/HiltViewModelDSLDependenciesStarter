package com.codingwithmitch.LittleNemo.presentation

import com.codingwithmitch.LittleNemo.PictureDataSource

object PictureInit {
    init {
        val pictures :MutableList<Picture> = PictureDataSource().data()
        PicturesState.pictures = pictures
    }
}