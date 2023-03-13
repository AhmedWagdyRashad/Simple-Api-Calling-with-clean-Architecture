package com.example.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.domain.entity.Category
import com.example.domain.entity.CategoryResponse
import com.example.domain.entity.Entry
import kotlinx.coroutines.flow.Flow

@Dao
interface MyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllCategory(list: List<Category>)

    @Query("SELECT * FROM category")
    fun getAllCategory(): Flow<List<Category>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insetAllItem(list:List<Entry>)

    @Query("SELECT * FROM entry")
    fun getAllItems():Flow<List<Entry>>
}