package com.example.fawrytask.ui.category

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entity.CategoryResponse
import com.example.domain.usecase.GetCategory
import com.example.domain.utils.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel  @Inject constructor(
    private val getCategoryUseCase: GetCategory
): ViewModel() {
    private val _categories: MutableStateFlow<CategoryResponse?> = MutableStateFlow(null)
    val categories: StateFlow<CategoryResponse?> = _categories

    fun getCategory(){
        viewModelScope.launch(Dispatchers.IO){
            try {
                when(val response = getCategoryUseCase()){
                    is Result.Success -> {
                        _categories.value = response.data
                        Log.e("CategoryViewModel" , "${response.data}")
                    }
                    is Result.Error -> {
                        Log.e("CategoryViewModel" , "${response.message}")
                    }
                }
            } catch (e: Exception){
                Log.e("CategoryViewModel", e.message.toString())
            }
        }
    }
}