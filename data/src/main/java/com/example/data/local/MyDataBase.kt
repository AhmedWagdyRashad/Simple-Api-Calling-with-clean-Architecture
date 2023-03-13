package com.example.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.domain.entity.Category
import com.example.domain.entity.Entry

@Database(entities = [Category::class, Entry::class], version = 1, exportSchema = false)
abstract class MyDataBase: RoomDatabase() {
    abstract fun myDao(): MyDao
}