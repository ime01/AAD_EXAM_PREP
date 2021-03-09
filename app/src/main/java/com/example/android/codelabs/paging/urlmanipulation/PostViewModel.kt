package com.example.android.codelabs.paging.urlmanipulation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.codelabs.paging.urlmanipulation.model.Post
import kotlinx.coroutines.launch
import retrofit2.Response

class PostViewModel (private val repository: PostsRepository): ViewModel(){

    var myResponse : MutableLiveData<Response<Post>> = MutableLiveData()
    var myResponse2 : MutableLiveData<Response<Post>> = MutableLiveData()
    var myCustomPosts : MutableLiveData<Response<List<Post>>> = MutableLiveData()
    var myCustomPosts2 : MutableLiveData<Response<List<Post>>> = MutableLiveData()
    var myCustomPosts3 : MutableLiveData<Response<List<Post>>> = MutableLiveData()

    fun getPosts(){
        viewModelScope.launch {
            val response = repository.getPosts()
            myResponse.value = response
        }
    }

    fun getPost2(number:Int){
        viewModelScope.launch {
            val response = repository.getPosts2(number)
            myResponse2.value = response

        }
    }

    fun getCustomPosts(userId: Int){
        viewModelScope.launch {
            val response = repository.getCustomPosts(userId)
            myCustomPosts.value = response
        }
    }

    fun getCustomPosts2(userId: Int, sort:String, order:String){
        viewModelScope.launch {
            val response = repository.getCustomPosts2(userId, sort, order)
            myCustomPosts2.value = response
        }
    }

    fun getCustomPosts3(userId: Int, options: Map<String, String>){
        viewModelScope.launch {
            val response = repository.getCustomPosts3(userId, options )
            myCustomPosts3.value = response
        }
    }


}