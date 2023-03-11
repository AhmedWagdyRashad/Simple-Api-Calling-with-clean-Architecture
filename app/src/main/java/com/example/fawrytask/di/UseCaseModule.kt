package com.example.fawrytask.di

import com.example.data.remote.ApiService
import com.example.data.repo.CategoriesImpl
import com.example.data.repo.ItemsImpl
import com.example.domain.repo.CategoryRepo
import com.example.domain.repo.ItemsRepo
import com.example.domain.usecase.GetCategory
import com.example.domain.usecase.GetItems
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    fun provideGetCategoryUseCase(categoryRepo: CategoryRepo): GetCategory{
        return GetCategory(categoryRepo)
    }
    @Provides
    fun provideGetItemsUseCase(itemsRepo: ItemsRepo): GetItems{
        return GetItems(itemsRepo)
    }
}