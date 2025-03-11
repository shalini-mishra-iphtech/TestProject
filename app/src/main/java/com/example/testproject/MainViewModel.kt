package com.example.testproject

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testproject.repository.PostRepository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: PostRepository):ViewModel() {

    fun fetchPosts(){
        viewModelScope.launch {
            val posts=repository.fetchPosts()
        }
    }
}