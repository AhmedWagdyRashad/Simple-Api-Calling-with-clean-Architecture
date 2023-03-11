package com.example.domain.repo

import com.example.domain.entity.CategoryResponse
import com.example.domain.entity.ItemResponse

interface CategoryRepo {
    suspend fun getCategoriesFromRemote(): CategoryResponse
}