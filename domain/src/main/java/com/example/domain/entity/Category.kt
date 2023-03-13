package com.example.domain.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("category")
data class Category(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val category: String)
