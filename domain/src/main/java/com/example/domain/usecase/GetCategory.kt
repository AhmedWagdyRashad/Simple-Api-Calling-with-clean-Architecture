package com.example.domain.usecase

import com.example.domain.repo.CategoryRepo

class GetCategory(private val myRepo: CategoryRepo) {
suspend operator fun invoke () = myRepo.getCategoriesFromRemote()
}