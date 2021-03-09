package com.example.android.codelabs.paging.urlmanipulation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class PostViewModelFactory (private val repository: PostsRepository): ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PostViewModel(repository) as T
    }
}