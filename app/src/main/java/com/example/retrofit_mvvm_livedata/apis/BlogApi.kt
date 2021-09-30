package com.example.retrofit_mvvm_livedata.apis

import com.example.retrofit_mvvm_livedata.models.Posts
import retrofit2.http.GET

interface BlogApi {
    @GET("posts")
    suspend fun getPost(): List<Posts>
}