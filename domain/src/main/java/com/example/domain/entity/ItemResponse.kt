package com.example.domain.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

data class ItemResponse(
    val count: Int,
    val entries: MutableList<Entry>
)