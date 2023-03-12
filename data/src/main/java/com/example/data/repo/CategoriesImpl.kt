package com.example.data.repo

import com.example.data.remote.ApiService
import com.example.domain.entity.CategoryResponse
import com.example.domain.entity.ItemResponse
import com.example.domain.repo.CategoryRepo
import com.example.domain.utils.NetworkResult
import kotlinx.coroutines.flow.callbackFlow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoriesImpl(private val apiService: ApiService) : CategoryRepo {
    override suspend fun getCategoriesFromRemote(): NetworkResult<CategoryResponse> {
        return try {
            val response = apiService.getCategories()
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
/* try {
            val response = apiService.getCategories()
            val result = response.body()
            if (response.isSuccessful && result != null) {
                NetworkResult.Success(result)
            } else {
                NetworkResult.Error(response.message())
            }
        }catch (e:Exception){
            NetworkResult.Error(e.message ?: "An error occured")*/