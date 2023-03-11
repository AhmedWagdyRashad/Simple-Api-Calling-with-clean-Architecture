package com.example.data.repo

import com.example.data.remote.ApiService
import com.example.domain.entity.CategoryResponse
import com.example.domain.entity.ItemResponse
import com.example.domain.repo.CategoryRepo

class CategoriesImpl(private val apiService: ApiService):CategoryRepo {
    override suspend fun getCategoriesFromRemote(): CategoryResponse  = apiService.getCategories()
}