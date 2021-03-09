package com.example.android.codelabs.paging.urlmanipulation.model


import com.google.gson.annotations.SerializedName

data class Post(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)