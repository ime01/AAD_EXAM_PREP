package com.example.android.codelabs.paging.urlmanipulation.network

import com.example.android.codelabs.paging.api.GithubService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import java.util.concurrent.TimeUnit

const val BASEURL = "https://jsonplaceholder.typicode.com/"




fun postsNetworkCall(): SimpleApi {
    val okHttpClient = OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .build()

    return Retrofit.Builder()
            .baseUrl(BASEURL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SimpleApi::class.java)
}