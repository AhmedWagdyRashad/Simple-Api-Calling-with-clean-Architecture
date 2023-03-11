package com.example.domain.repo

import com.example.domain.entity.CategoryResponse
import com.example.domain.entity.ItemResponse

interface ItemsRepo {
    suspend fun getItemsFromRemote(category:String): ItemResponse
}