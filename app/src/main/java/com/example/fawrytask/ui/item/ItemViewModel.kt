package com.example.fawrytask.ui.item

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entity.CategoryResponse
import com.example.domain.entity.ItemResponse
import com.example.domain.usecase.GetItems
import com.example.domain.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ItemViewModel @Inject constructor(
    private val getItemUseCase: GetItems
): ViewModel(){

    private val _items: MutableStateFlow<ItemResponse?> = MutableStateFlow(null)
    val items: StateFlow<ItemResponse?> = _items

    fun getItem(category:String){
        viewModelScope.launch(Dispatchers.IO){
            try {
                when(val response = getItemUseCase(category)){
                    is NetworkResult.Success -> {
                        _items.value = response.data
                        Log.e("CategoryViewModel" , "${response.data}")
                    }
                    is NetworkResult.Error -> {
                        Log.e("CategoryViewModel" , "${response.message}")
                    }
                }
            } catch (e: Exception){
                Log.e("CategoryViewModel", e.message.toString())
            }
        }
    }
}