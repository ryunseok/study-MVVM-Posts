package com.example.ryunseok.mvvmposts.base

import android.arch.lifecycle.ViewModel
import com.example.ryunseok.mvvmposts.injection.component.DaggerViewModelInjector
import com.example.ryunseok.mvvmposts.injection.component.ViewModelInjector
import com.example.ryunseok.mvvmposts.injection.module.NetworkModule
import com.example.ryunseok.mvvmposts.ui.PostListViewModel


abstract class BaseViewModel: ViewModel(){
    private val injector: ViewModelInjector = DaggerViewModelInjector
            .builder()
            .networkModule(NetworkModule)
            .build()

    init {
        inject()
    }

    /**
     *  Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is PostListViewModel -> injector.inject(this)
        }
    }

}

