package com.example.expensemanager.data.datasource

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert
import com.example.expensemanager.data.model.ExpenseEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ExpenseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertExpense(expenseEntity: ExpenseEntity)

    @Delete
    suspend fun deleteExpense(expenseEntity: ExpenseEntity)

    @Query("select * from ExpenseEntity where id = :id")
    suspend fun getExpenseById(id: String): List<ExpenseEntity>

    @Query("select * from ExpenseEntity")
    fun getAllExpense(): Flow<List<ExpenseEntity>>


}