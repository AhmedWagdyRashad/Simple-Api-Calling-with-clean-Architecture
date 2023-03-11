package com.example.data.repo

import com.example.data.remote.ApiService
import com.example.domain.entity.CategoryResponse
import com.example.domain.entity.ItemResponse
import com.example.domain.repo.CategoryRepo
import com.example.domain.repo.ItemsRepo

class ItemsImpl(private val apiService: ApiService):ItemsRepo {
    override suspend fun getItemsFromRemote(category: String): ItemResponse
    = apiService.getItems(category = category)
}