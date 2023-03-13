package com.example.data.remote

import com.example.domain.entity.CategoryResponse
import com.example.domain.entity.ItemResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    companion object {
        const val BASE_URL = "https://api.publicapis.org/"
    }

    @GET(EndPoint.CATEGORIES)
    suspend fun getCategories(): Response<CategoryResponse>

    @GET(EndPoint.ENTRIES)
    suspend fun getItems(@Query("category") category: String): Response<ItemResponse>
}