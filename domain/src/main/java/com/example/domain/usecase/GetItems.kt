package com.example.domain.usecase

import com.example.domain.repo.ItemsRepo

class GetItems (private val myRepo: ItemsRepo) {
    suspend operator fun invoke (category:String) = myRepo.getItemsFromRemote(category)
}