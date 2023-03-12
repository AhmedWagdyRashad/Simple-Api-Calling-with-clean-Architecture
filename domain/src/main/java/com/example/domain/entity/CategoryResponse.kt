package com.example.domain.entity

data class CategoryResponse(
    val categories: MutableList<String>,
    val count: Int
)