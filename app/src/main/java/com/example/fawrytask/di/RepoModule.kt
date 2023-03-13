package com.example.fawrytask.di

import com.example.data.local.MyDataBase
import com.example.data.remote.ApiService
import com.example.data.repo.CategoriesImpl
import com.example.data.repo.ItemsImpl
import com.example.domain.repo.CategoryRepo
import com.example.domain.repo.ItemsRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {
    @Provides
    fun provideCategoryRepo(apiService: ApiService, myDataBase: MyDataBase): CategoryRepo{
        return CategoriesImpl(apiService, myDataBase)
    }
    @Provides
    fun provideItemRepo(apiService: ApiService, myDataBase: MyDataBase): ItemsRepo {
        return ItemsImpl(apiService, myDataBase)
    }
}