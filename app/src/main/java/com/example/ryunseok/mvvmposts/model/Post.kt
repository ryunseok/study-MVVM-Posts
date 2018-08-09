package com.example.ryunseok.mvvmposts.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Class which provides a model for post
 * @constructor Sets all properties of the post
 * @property userId the unique identifier of the author of the post
 * @property id the unique identifier of the post
 * @property title the title of the post
 * @property body the content of the post
 */

data class Post(
        val dateTime:String,
        val category:String,
        val filePath:String,
        val fileSize:Float,
        val id:Int,
        val isDirectory:Boolean,
        val parentFolder:String
)


