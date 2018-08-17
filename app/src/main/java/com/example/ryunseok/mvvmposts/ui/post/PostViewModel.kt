package com.example.ryunseok.mvvmposts.ui.post

import android.arch.lifecycle.MutableLiveData
import com.example.ryunseok.mvvmposts.base.BaseViewModel
import com.example.ryunseok.mvvmposts.model.Post

class PostViewModel:BaseViewModel() {
    private val postTitle = MutableLiveData<String>()
    private val postCategory = MutableLiveData<String>()
    private val postDate = MutableLiveData<String>()
    private val postFileSize = MutableLiveData<Float>()
    private val postFilePath = MutableLiveData<String>()
    private val postIsDirectory = MutableLiveData<String>()
    private val postParentFolder = MutableLiveData<String>()

    fun bind(post: Post) {
        postTitle.value = post.filePath.replace(".pdf","")
        postCategory.value = post.category
        postIsDirectory.value = "Directory : " + post.isDirectory.toString()
    }

    fun getPostTitle(): MutableLiveData<String> {

        return postTitle
    }

    fun getPostIsDirectory(): MutableLiveData<String> {
        return postIsDirectory
    }
}