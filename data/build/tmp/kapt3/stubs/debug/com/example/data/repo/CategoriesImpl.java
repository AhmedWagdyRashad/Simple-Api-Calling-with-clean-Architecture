package com.example.data.repo;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\r"}, d2 = {"Lcom/example/data/repo/CategoriesImpl;", "Lcom/example/domain/repo/CategoryRepo;", "apiService", "Lcom/example/data/remote/ApiService;", "myDataBase", "Lcom/example/data/local/MyDataBase;", "(Lcom/example/data/remote/ApiService;Lcom/example/data/local/MyDataBase;)V", "myDao", "Lcom/example/data/local/MyDao;", "getCategoriesFromRemote", "Lcom/example/domain/utils/Result;", "Lcom/example/domain/entity/CategoryResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_debug"})
public final class CategoriesImpl implements com.example.domain.repo.CategoryRepo {
    private final com.example.data.remote.ApiService apiService = null;
    private final com.example.data.local.MyDataBase myDataBase = null;
    private final com.example.data.local.MyDao myDao = null;
    
    public CategoriesImpl(@org.jetbrains.annotations.NotNull()
    com.example.data.remote.ApiService apiService, @org.jetbrains.annotations.NotNull()
    com.example.data.local.MyDataBase myDataBase) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getCategoriesFromRemote(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.domain.utils.Result<com.example.domain.entity.CategoryResponse>> continuation) {
        return null;
    }
}