package com.example.expensemanager.di

import android.content.Context
import androidx.compose.ui.tooling.preview.Preview
import androidx.room.Room
import com.example.expensemanager.data.ExpenseRepositoryImpl
import com.example.expensemanager.data.datasource.ExpenseDao
import com.example.expensemanager.domain.repository.ExpenseRepository
import com.example.expensemanager.room.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun getExpenseDao(appDataBase: AppDatabase):ExpenseDao{
        return appDataBase.expenseDao()
    }
    @Provides
    @Singleton
    fun getDb(@ApplicationContext context: Context):AppDatabase{
        return Room.databaseBuilder(context,AppDatabase::class.java,"app_db").build()
    }
    @Provides
    @Singleton
    fun provideExpenseRepositoryImpl(dao: ExpenseDao): ExpenseRepository {
        return ExpenseRepositoryImpl(dao)
    }
}