package com.example.testproject.repository

import android.util.Log
import com.example.testproject.model.Post
import com.example.testproject.network.RetrofitClient
import com.example.testproject.utils.SharedPrefManager

class PostRepository(private val sharedPrefManager: SharedPrefManager) {
    suspend fun fetchPosts(): List<Post>? {
        try {
            val response = RetrofitClient.instance.getPosts()
            if (response.isSuccessful) {
                response.body()?.let { posts ->
                    // Handle possible null values
                    val cleanedPosts = posts.map {
                        Post(
                            userId = it.userId,
                            id = it.id,
                            title = it.title,
                            body = it.body
                        )
                    }
                    sharedPrefManager.savePosts(cleanedPosts)
                    Log.d("API_RESPONSE", cleanedPosts.toString())
                    return cleanedPosts
                }
            } else {
                Log.e("API_ERROR", "Failed to fetch posts: ${response.errorBody()?.string()}")
            }
        } catch (e: Exception) {
            Log.e("API_ERROR", "Exception: ${e.message}")
        }
        return null
    }
}