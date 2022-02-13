package com.codingwithmitch.LittleNemo

import com.codingwithmitch.LittleNemo.presentation.Picture

class PictureDataSource {

    fun data():MutableList<Picture>{
        var pictures : MutableList<Picture> = mutableListOf()
        pictures.add(Picture(0,"text 1","https://upload.wikimedia.org/wikipedia/commons/8/85/Logo-Test.png"))
        pictures.add(Picture(1,"text 2","https://upload.wikimedia.org/wikipedia/commons/8/85/Logo-Test.png"))
        pictures.add(Picture(2,"text 3","https://upload.wikimedia.org/wikipedia/commons/8/85/Logo-Test.png"))
        return pictures
    }
}