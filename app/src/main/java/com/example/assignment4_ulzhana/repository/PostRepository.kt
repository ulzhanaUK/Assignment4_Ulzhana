package com.example.assignment4_ulzhana.repository

import com.example.assignment4_ulzhana.retro.ApiService
import com.example.assignment4_ulzhana.retro.RetrofitClient

class PostRepository {
    private val apiService = RetrofitClient.retrofit.create(ApiService::class.java)

    suspend fun getPosts() = apiService.getPosts()

    suspend fun getPostById(id: Int) = apiService.getPostById(id)
}
