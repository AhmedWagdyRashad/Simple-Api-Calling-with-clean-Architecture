package com.example.data.repo

import com.example.data.local.MyDataBase
import com.example.data.remote.ApiService
import com.example.domain.entity.ItemResponse
import com.example.domain.repo.ItemsRepo
import com.example.domain.utils.Result

class ItemsImpl(private val apiService: ApiService, private val myDataBase: MyDataBase):ItemsRepo {
    val myDao = myDataBase.myDao()
    override suspend fun getItemsFromRemote(category: String): Result<ItemResponse> {
        return try {
            val response = apiService.getItems(category = category)
            val result = response.body()
            if (response.isSuccessful && result != null) {
                Result.Success(result)
            } else {
                Result.Error(response.message())
            }
        } catch (e: Exception) {
            Result.Error(e.message ?: "An error occured")
        }
    }
}