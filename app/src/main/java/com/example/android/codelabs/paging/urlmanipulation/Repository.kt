package com.example.android.codelabs.paging.urlmanipulation

import com.example.android.codelabs.paging.urlmanipulation.model.Post
import com.example.android.codelabs.paging.urlmanipulation.network.postsNetworkCall
import retrofit2.Response

class PostsRepository {

    suspend fun getPosts(): Response<Post>{
        return postsNetworkCall().getPost()
    }

    suspend fun getPosts2(number:Int): Response<Post>{
        return postsNetworkCall().getPost2(number)
    }

    suspend fun getCustomPosts(userId: Int): Response<List<Post>>{
        return postsNetworkCall().getCustomPosts(userId)
    }

    suspend fun getCustomPosts2(userId: Int, sort:String, order:String): Response<List<Post>>{
        return postsNetworkCall().getCustomPosts2(userId, sort, order)
    }

    suspend fun getCustomPosts3(userId: Int,  options: Map<String, String>): Response<List<Post>>{
        return postsNetworkCall().getCustomPosts3(userId, options)
    }


}