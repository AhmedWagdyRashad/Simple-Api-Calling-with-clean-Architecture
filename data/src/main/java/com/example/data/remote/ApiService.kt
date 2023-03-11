package com.example.data.remote

import com.example.domain.entity.CategoryResponse
import com.example.domain.entity.ItemResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    companion object {
        const val BASE_URL = "https://api.publicapis.org/"
    }
    @GET(EndPoint.CATEGORIES)
    fun getCategories(): CategoryResponse

    @GET(EndPoint.ENTRIES)
    fun getItems(@Query("category") category: String): ItemResponse
}