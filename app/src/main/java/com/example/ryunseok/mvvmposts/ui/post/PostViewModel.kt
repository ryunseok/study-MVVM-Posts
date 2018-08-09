package com.example.ryunseok.mvvmposts.ui.post

import android.arch.lifecycle.MutableLiveData
import com.example.ryunseok.mvvmposts.base.BaseViewModel
import com.example.ryunseok.mvvmposts.model.Post

class PostViewModel:BaseViewModel() {
    private val postTitle = MutableLiveData<String>()
    private val postBody = MutableLiveData<String>()

    fun bind(post: Post) {
        postTitle.value = post.filePath
        postBody.value = post.category
    }

    fun getPostTitle(): MutableLiveData<String> {
        return postTitle
    }

    fun getPostBody(): MutableLiveData<String> {
        return postBody
    }
}