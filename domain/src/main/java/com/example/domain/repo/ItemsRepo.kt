package com.example.domain.repo

import com.example.domain.entity.ItemResponse
import com.example.domain.utils.Result

interface ItemsRepo {
    suspend fun getItemsFromRemote(category:String): Result<ItemResponse>
}