package com.example.expensemanager.presentation.add_expense_manager

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController


@Composable
fun ScoreButton(btn: String, onClick: () -> Unit) {
    Box(modifier = Modifier.padding(5.dp)) {
        FloatingActionButton(
            onClick = {
                onClick()
            }, shape = CircleShape, contentColor = Color.White,

            modifier = Modifier.size(80.dp)
        ) {
            Text(text = btn, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        }
    }
}


@Composable
fun AddExpenseScreen(
    id: String, navController: NavController, viewModel: AddExpenseViewModel = hiltViewModel()
) {
    LaunchedEffect(Unit) {
        if (id.toInt() != -1) {
            viewModel.getTheDataById(id)
        }
    }
    val buttonList = listOf(
        "Single", "Double", "Six", "Four"
    )

    val state = viewModel.state.collectAsState().value
    Log.d("statevalue", state.totalScores.toString())

    LazyVerticalGrid(columns = GridCells.Fixed(4)) {
        items(buttonList) {
            ScoreButton(btn = it, onClick = {
                viewModel.onButtonClick(it)
                viewModel.onSaveItem()
            })
        }
    }
}
