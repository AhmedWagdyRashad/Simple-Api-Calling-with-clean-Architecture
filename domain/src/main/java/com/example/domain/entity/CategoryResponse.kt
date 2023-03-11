package com.example.domain.entity

data class CategoryResponse(
    val count: Int,
    val categories: MutableList<String>
)