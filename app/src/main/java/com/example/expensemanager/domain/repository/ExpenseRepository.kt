package com.example.expensemanager.domain.repository

import com.example.expensemanager.data.model.ExpenseEntity

interface ExpenseRepository {
    suspend fun insertScores(expenseEntity: ExpenseEntity)
    suspend fun deleteExpense(expenseEntity: ExpenseEntity)
    suspend fun getExpenseById(mId: String): List<ExpenseEntity>
    suspend fun getAllExpense(): kotlinx.coroutines.flow.Flow<List<ExpenseEntity>>
}