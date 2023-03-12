package com.example.domain.repo

import com.example.domain.entity.CategoryResponse
import com.example.domain.entity.ItemResponse
import com.example.domain.utils.NetworkResult

interface ItemsRepo {
    suspend fun getItemsFromRemote(category:String): NetworkResult<ItemResponse>
}