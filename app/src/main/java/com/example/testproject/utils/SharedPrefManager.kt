package com.example.testproject.utils

import android.content.Context
import com.example.testproject.model.Post
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class SharedPrefManager(context: Context) {

    private val sharedPreferences =
        context.getSharedPreferences("MyAppPreferences", Context.MODE_PRIVATE)

    fun savePosts(posts: List<Post>) {
        val json = Gson().toJson(posts)
        sharedPreferences.edit().putString("posts", json).apply()
    }

    fun getPosts(): List<Post>? {
        val json = sharedPreferences.getString("posts", null)
        return if (json != null) {
            val type = object : TypeToken<List<Post>>() {}.type
            Gson().fromJson(json, type)
        } else {
            null
        }
    }

    companion object {
        @Volatile
        private var instance: SharedPrefManager? = null

        fun getInstance(context: Context): SharedPrefManager {
            return instance ?: synchronized(this) {
                instance ?: SharedPrefManager(context).also { instance = it }
            }
        }
    }
}
