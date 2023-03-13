package com.example.domain.entity

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey


data class CategoryResponse(
    val categories: MutableList<String>,
    val count: Int
)