package com.example.expensemanager.presentation.expense_screen

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
        getAllData()
    }


    private fun getAllData() {
        viewModelScope.launch {
            repository.getAllExpense().collectLatest { list ->
                var totalScores = 0
                var player1Scores = 0
                var player2Scores = 0
                mainState.update {
                    it.copy(
                        totalScores = totalScores,
                        player1Scores = player1Scores,
                        player2Scores = player2Scores
                    )
                }
                for (items in list) {
                    totalScores += items.totalScores
                    player1Scores += items.player1Scores
                    player2Scores += items.player2Scores
                }
                mainState.update {
                    it.copy(
                        totalScores = totalScores,
                        player1Scores = player1Scores,
                        player2Scores = player2Scores,
                    )
                }

            }
        }
    }

}


