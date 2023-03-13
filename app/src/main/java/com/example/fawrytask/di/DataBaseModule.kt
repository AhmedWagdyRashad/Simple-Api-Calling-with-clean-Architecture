package com.example.fawrytask.di

import android.app.Application
import androidx.room.Room
import com.example.data.local.MyDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {
    @Provides
    @Singleton
    fun provideDatabase(app: Application): MyDataBase =
        Room.databaseBuilder(app, MyDataBase::class.java, "my_data_base")
            .fallbackToDestructiveMigration()
            .build()
}