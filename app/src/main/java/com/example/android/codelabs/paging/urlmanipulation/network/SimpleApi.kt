package com.example.android.codelabs.paging.urlmanipulation.network

import com.example.android.codelabs.paging.urlmanipulation.model.Post
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface SimpleApi {

    @GET("posts/1")
    suspend fun getPost():  Response<Post>


    @GET("posts/{postNumber}")
    suspend fun getPost2(@Path("postNumber")number:Int) : Response<Post>

    @GET("posts")
    suspend fun getCustomPosts(@Query("userId")number: Int): Response<List<Post>>

    @GET("posts")
    suspend fun getCustomPosts2(@Query("userId")number: Int, @Query("_sort") sort: String, @Query("_order") order:String): Response<List<Post>>

    @GET("posts")
    suspend fun getCustomPosts3(@Query("userId")number: Int,
                                @QueryMap options: Map<String, String>): Response<List<Post>>
}