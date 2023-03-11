package com.example.fawrytask.di

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
    fun provideCategoryRepo(apiService: ApiService): CategoryRepo{
        return CategoriesImpl(apiService)
    }
    @Provides
    fun provideItemRepo(apiService: ApiService): ItemsRepo {
        return ItemsImpl(apiService)
    }
}