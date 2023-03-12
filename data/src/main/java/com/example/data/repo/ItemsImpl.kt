package com.example.data.repo

import com.example.data.remote.ApiService
import com.example.domain.entity.CategoryResponse
import com.example.domain.entity.ItemResponse
import com.example.domain.repo.CategoryRepo
import com.example.domain.repo.ItemsRepo
import com.example.domain.utils.NetworkResult

class ItemsImpl(private val apiService: ApiService):ItemsRepo {
    override suspend fun getItemsFromRemote(category: String): NetworkResult<ItemResponse> {
        return try {
            val response = apiService.getItems(category = category)
            val result = response.body()
            if (response.isSuccessful && result != null) {
                NetworkResult.Success(result)
            } else {
                NetworkResult.Error(response.message())
            }
        } catch (e: Exception) {
            NetworkResult.Error(e.message ?: "An error occured")
        }
    }
}