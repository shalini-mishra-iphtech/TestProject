package com.example.testproject

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testproject.model.Post
import com.example.testproject.repository.PostRepository
import kotlinx.coroutines.launch

class MainViewModel(context: MainActivity):ViewModel() {

    /*
    fun fetchPosts(){
        viewModelScope.launch {
            val posts=repository.fetchPosts()
        }
    }
    */
    private val repository = PostRepository(context)

    val savedPosts: List<Post>?
        get() = repository.getSavedPosts()

    fun fetchPosts() {
        viewModelScope.launch {
            repository.getPosts()
        }
    }


}