package com.codingwithmitch.food2forkcompose

import com.codingwithmitch.food2forkcompose.presentation.Picture

class PictureDataSource {

    fun data():MutableList<Picture>{
        var pictures : MutableList<Picture> = mutableListOf()
        pictures.add(Picture(0,"text 1","link1"))
        pictures.add(Picture(1,"text 2","link2"))
        pictures.add(Picture(2,"text 3","link3"))
        return pictures
    }
}