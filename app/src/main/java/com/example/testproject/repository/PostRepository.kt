package com.example.testproject.repository

import android.content.Context
import android.util.Log
import com.example.testproject.model.Post
import com.example.testproject.network.RetrofitClient
import com.example.testproject.utils.SharedPrefManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostRepository(context: Context) {
    /*

    fun fetchPosts(): List<Post>? {
        try {
            val response = RetrofitClient.instance.getPosts()
            if (response.isSuccessful) {
                response.body()?.let { posts ->
                    for(post in posts){
//                        Log.d("API_RESPONSE","-----------------------")
//                        Log.d("API_RESPONSE","UserId:${post.userId}")
//                        Log.d("API_RESPONSE","Id:${post.id}")
//                        Log.d("API_RESPONSE","Title:${post.title}")
//                        Log.d("API_RESPONSE","Body:${post.body}")
                    }
                    sharedPrefManager.savePosts(posts)
                    val abd = sharedPrefManager.getPosts()
                    Log.d("API_RESPONSE","sharedPrefManager: $abd}")

                }

            } else {
                Log.e("API_ERROR", "Failed to fetch posts: ${response.errorBody()?.string()}")
            }
        } catch (e: Exception) {
            Log.e("API_ERROR", "Exception: ${e.message}")
        }
        return null
    }


*/

    private val apiService = RetrofitClient.instance
    private val sharedPreferencesManager = SharedPrefManager(context)

    suspend fun getPosts() {
        try {
            val response = apiService.getPosts()
            if (response.isSuccessful) {
                response.body()?.let { posts ->
                    Log.d("PostRepository", "Fetched Posts: $posts")
                    sharedPreferencesManager.savePosts(posts)
                }
            } else {
                Log.e("PostRepository", "Failed to fetch data: ${response.code()}")
            }
        } catch (e: Exception) {
            Log.e("PostRepository", "Error: ${e.message}")
        }
    }

    fun getSavedPosts(): List<Post>? {
        return sharedPreferencesManager.getPosts()
    }
}






