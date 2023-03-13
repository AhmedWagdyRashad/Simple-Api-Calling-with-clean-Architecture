package com.example.data.repo

import com.example.data.local.MyDataBase
import com.example.data.remote.ApiService
import com.example.domain.entity.CategoryResponse
import com.example.domain.repo.CategoryRepo
import com.example.domain.utils.Result

class CategoriesImpl  (
    private val apiService: ApiService,
    private val myDataBase: MyDataBase
) : CategoryRepo {
    private val myDao = myDataBase.myDao()
    override suspend fun getCategoriesFromRemote(): Result<CategoryResponse> {
        return try {
            val response = apiService.getCategories()
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
/* try {
            val response = apiService.getCategories()
            val result = response.body()
            if (response.isSuccessful && result != null) {
                Result.Success(result)
            } else {
                Result.Error(response.message())
            }
        }catch (e:Exception){
            Result.Error(e.message ?: "An error occured")*/