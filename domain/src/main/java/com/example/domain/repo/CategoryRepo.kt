package com.example.domain.repo

import com.example.domain.entity.CategoryResponse
import com.example.domain.utils.Result

interface CategoryRepo {
    suspend fun getCategoriesFromRemote(): Result<CategoryResponse>

}