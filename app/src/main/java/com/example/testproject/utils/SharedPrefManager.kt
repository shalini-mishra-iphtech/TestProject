package com.example.testproject.utils

import android.content.Context
import android.content.SharedPreferences
import com.example.testproject.model.Post
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class SharedPrefManager(context:Context) {
    private val sharedPreferences:SharedPreferences= context.getSharedPreferences("app_prefs",Context.MODE_PRIVATE)
    private val editor:SharedPreferences.Editor=sharedPreferences.edit()

    fun savePosts(posts :List<Post>){
        val json= Gson().toJson(posts)
        editor.putString("posts",json)
        editor.apply()
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
}