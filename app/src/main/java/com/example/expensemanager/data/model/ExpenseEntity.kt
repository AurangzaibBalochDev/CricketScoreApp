package com.example.expensemanager.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class ExpenseEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val totalScores: Int = 0,
    val player1Scores: Int= 0,
    val player2Scores: Int = 0,

    )
