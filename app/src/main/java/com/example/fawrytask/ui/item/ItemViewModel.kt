package com.example.fawrytask.ui.item

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entity.CategoryResponse
import com.example.domain.entity.ItemResponse
import com.example.domain.usecase.GetItems
import dagger.hilt.android.lifecycle.HiltViewModel
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
        viewModelScope.launch{
            try {
                _items.value = getItemUseCase(category)
            } catch (e: Exception){
                Log.e("CategoryViewModel", e.message.toString())
            }
        }
    }
}