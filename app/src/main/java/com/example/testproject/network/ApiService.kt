package com.example.testproject.network

import android.telecom.Call
import com.example.testproject.model.ApiResponse

interface ApiService {
    @GET("users?page=2")
    fun getMovies(): Call<ApiResponse>
}
data class ApiResponse(val data:List<MovieData>)