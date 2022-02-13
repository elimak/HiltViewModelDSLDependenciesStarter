package de.apps.LittleNemo.presentation

import de.apps.LittleNemo.PictureDataSource

object PictureInit {
    init {
        val pictures :MutableList<Picture> = PictureDataSource().data()
        PicturesState.pictures = pictures
    }
}