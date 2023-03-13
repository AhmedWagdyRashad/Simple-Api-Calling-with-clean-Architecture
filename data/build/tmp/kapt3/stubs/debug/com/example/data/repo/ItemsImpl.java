package com.example.data.repo;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u001f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0011"}, d2 = {"Lcom/example/data/repo/ItemsImpl;", "Lcom/example/domain/repo/ItemsRepo;", "apiService", "Lcom/example/data/remote/ApiService;", "myDataBase", "Lcom/example/data/local/MyDataBase;", "(Lcom/example/data/remote/ApiService;Lcom/example/data/local/MyDataBase;)V", "myDao", "Lcom/example/data/local/MyDao;", "getMyDao", "()Lcom/example/data/local/MyDao;", "getItemsFromRemote", "Lcom/example/domain/utils/Result;", "Lcom/example/domain/entity/ItemResponse;", "category", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_debug"})
public final class ItemsImpl implements com.example.domain.repo.ItemsRepo {
    private final com.example.data.remote.ApiService apiService = null;
    private final com.example.data.local.MyDataBase myDataBase = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.data.local.MyDao myDao = null;
    
    public ItemsImpl(@org.jetbrains.annotations.NotNull()
    com.example.data.remote.ApiService apiService, @org.jetbrains.annotations.NotNull()
    com.example.data.local.MyDataBase myDataBase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.data.local.MyDao getMyDao() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getItemsFromRemote(@org.jetbrains.annotations.NotNull()
    java.lang.String category, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.domain.utils.Result<com.example.domain.entity.ItemResponse>> continuation) {
        return null;
    }
}