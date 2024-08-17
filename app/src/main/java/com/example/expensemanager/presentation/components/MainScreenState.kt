package com.example.expensemanager.presentation.components

import com.example.expensemanager.data.model.ExpenseEntity

data class MainScreenState(
    val itemsList: List<ExpenseEntity> = emptyList(),
    val totalIncome: Int = 0,
    val totalExpense: Int = 0,
    val totalBalance: Int = 0
)
