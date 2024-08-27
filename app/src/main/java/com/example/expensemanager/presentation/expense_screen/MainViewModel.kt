package com.example.expensemanager.presentation.expense_screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.expensemanager.data.model.ExpenseEntity
import com.example.expensemanager.domain.repository.ExpenseRepository
import com.example.expensemanager.presentation.components.MainScreenState
import com.example.expensemanager.presentation.main_screen.components.EntryType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.math.exp

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: ExpenseRepository,
) : ViewModel() {
    private val mainState = MutableStateFlow(MainScreenState())
    val state = mainState.asStateFlow()

    init {
        refreshData()
    }


    private fun refreshData() {
        viewModelScope.launch {
            repository.getAllExpense().collectLatest { list ->
                val totalExpense = list.sumOf { it.player1Scores + it.player2Scores }
                val player1Expense = list.sumOf { it.player1Scores }
                val player2Expense = list.sumOf { it.player2Scores }
                mainState.update {
                    it.copy(
                        totalScores = totalExpense,
                        player1Scores = player1Expense,
                        player2Scores = player2Expense,
                    )
                }
            }
        }
    }

}


