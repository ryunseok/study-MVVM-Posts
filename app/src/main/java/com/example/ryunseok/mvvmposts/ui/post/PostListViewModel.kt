package com.example.ryunseok.mvvmposts.ui.post

import android.arch.lifecycle.MutableLiveData
import android.util.Log
import android.view.View
import com.example.ryunseok.mvvmposts.base.BaseViewModel
import com.example.ryunseok.mvvmposts.network.PostApi
import com.example.ryunseok.mvvmposts.R
import com.example.ryunseok.mvvmposts.model.Post

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import javax.inject.Inject

//class PostListViewModel(private val postDao: PostDao):BaseViewModel() {
class PostListViewModel():BaseViewModel() {

    @Inject
    lateinit var postApi: PostApi

    private lateinit var subscription: Disposable
    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
    val errorMessage:MutableLiveData<Int> = MutableLiveData()
    val errorClickListener = View.OnClickListener { loadPosts() }
    val postListAdapter: PostListAdapter = PostListAdapter()
    var url:String = ""


    init{
        loadPosts()
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }

    private fun loadPosts() {
        subscription = postApi.getPosts("novel/골든 타임 외전(2권 완결)")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { onRetrievePostListStart()}
                .doOnTerminate { onRetrievePostListFinish()}
                .subscribe(
                        { result -> onRetrievePostListSuccess(result)},
                        { onRetrievePostListError()}
                )
    }

    private fun onRetrievePostListStart(){
        loadingVisibility.value = View.VISIBLE
        errorMessage.value = null
    }

    private fun onRetrievePostListFinish(){
        loadingVisibility.value = View.GONE

    }
    private fun onRetrievePostListSuccess(postList:List<Post>){
        postListAdapter.updatePostList(postList)

    }

    private fun onRetrievePostListError(){
        errorMessage.value = R.string.post_error

    }
}