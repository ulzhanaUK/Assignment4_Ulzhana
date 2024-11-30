package com.example.assignment4_ulzhana

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assignment4_ulzhana.retro.Post
import com.example.assignment4_ulzhana.repository.PostRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PostViewModel : ViewModel() {
    private val repository = PostRepository()

    private val _posts = MutableStateFlow<List<Post>>(emptyList())
    val posts: StateFlow<List<Post>> get() = _posts

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> get() = _error

    fun fetchPosts() {
        viewModelScope.launch {
            try {
                val result = repository.getPosts()
                _posts.value = result
            } catch (e: Exception) {
                _error.value = e.message
            }
        }
    }
}
