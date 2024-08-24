package com.example.expensemanager.presentation.add_expense_manager

import android.util.Log
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.expensemanager.core.MyLocalData
import com.example.expensemanager.data.model.ExpenseEntity
import com.example.expensemanager.domain.repository.ExpenseRepository
import com.example.expensemanager.presentation.main_screen.components.EntryType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.Calendar
import javax.inject.Inject

@HiltViewModel
class AddExpenseViewModel @Inject constructor(
    private val repository: ExpenseRepository
) : ViewModel() {
    data class AddScreenState(
        var id: Int = -1,
        var totalScores: Int = 0,
        var player1Scores: Int = 0,
        var player2Scores: Int = 0,

        )


    private val _state = MutableStateFlow(AddScreenState())
    val state = _state.asStateFlow()



     fun onSaveItem() {
        viewModelScope.launch {
            try {
                val data = ExpenseEntity(
                    totalScores = state.value.totalScores,
                    player1Scores = state.value.player1Scores,
                    player2Scores = state.value.player2Scores,
                )
                if (state.value.id == -1) {
                    repository.insertExpense(data)
                }
                Log.d("addexpensevm", "saved data")

            } catch (e: Exception) {
                Log.d("addexpensevm", "onSaveItem: ${e.message}")
            }
        }
    }

    fun getTheDataById(id: String) {
        viewModelScope.launch {
            val save = repository.getExpenseById(id)
            val entity = save[0]
            if (id.isNotEmpty()) {
                _state.update {
                    it.copy(
                        id = entity.id,
                        totalScores = entity.totalScores,
                        player1Scores = entity.player1Scores,
                        player2Scores = entity.player2Scores,
                    )
                }
            }
        }
    }


    fun onButtonClick(btn: String) {
        _state.update { currentState ->
            val increment = when (btn) {
                "Single" -> 1
                "Double" -> 2
                "Four" -> 4
                "Six" -> 6
                else -> 0
            }
            currentState.copy(

                totalScores = currentState.totalScores + increment,
                player1Scores = currentState.player1Scores + increment,
                player2Scores = currentState.player2Scores + increment
            )
        }
    }
}
