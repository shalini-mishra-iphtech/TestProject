package com.example.testproject.network

import com.example.testproject.model.Post
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("posts")
    suspend fun getPosts(): Response<List<Post>>
}