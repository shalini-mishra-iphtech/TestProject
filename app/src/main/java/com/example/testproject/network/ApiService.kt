package com.example.testproject.network

import com.example.testproject.model.ApiResponse
import com.example.testproject.model.MovieData
import retrofit2.http.GET
import retrofit2.Call


interface ApiService {
    @GET("users?page=2")
    fun getMovies(): Call<ApiResponse>
}
data class ApiResponse(val data:List<MovieData>)