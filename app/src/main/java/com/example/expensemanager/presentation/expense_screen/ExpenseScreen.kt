package com.example.expensemanager.presentation.expense_screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.expensemanager.presentation.components.Screens
import com.example.expensemanager.presentation.expense_card.ExpenseCard
import com.example.expensemanager.presentation.main_screen.components.TopBar
import com.example.expensemanager.ui.theme.CustomColors

@Preview(showSystemUi = true)
@Composable
fun ExpenseScreen(
    navController: NavController,
    viewModel: MainViewModel = hiltViewModel()
) {
    val mainState = viewModel.state.collectAsState().value
    Scaffold(
        modifier = Modifier.fillMaxSize().padding(vertical = 25.dp), topBar = { TopBar() },
        floatingActionButton = {
            FloatingActionButton(modifier = Modifier.padding(bottom = 0.dp), onClick = {
                navController.navigate("${Screens.AddExpenseScreen.route}/${-1}")
            }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
            }
        },
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                elevation = CardDefaults.cardElevation(10.dp),
                colors = CardDefaults.cardColors(CustomColors.mainCardColor)
            ) {

                Column() {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.Center,
                    ) {

                        Text(
                            text = "Current Balance",
                            color = Color.DarkGray,
                            modifier = Modifier.padding(vertical = 5.dp)
                        )
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.Center,
                    ) {

//                        Text(text = mainState.totalIncome.toString(), color = Color.Green)
//                        Text(text = mainState.totalExpense.toString(), color = Color.Red)
                        Text(text = mainState.totalBalance.toString(), fontSize = 40.sp)
                    }

                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        modifier = Modifier
                    ) {
                        Text(text = "Income")
                    }
                    Row(
                    ) {
                        Text(text = "Expenses")
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        modifier = Modifier
                    ) {
                        Text(text = mainState.totalIncome.toString(), fontSize = 20.sp)
                    }
                    Row(
                    ) {
                        Text(text = mainState.totalExpense.toString(), fontSize = 20.sp)
                    }
                }


            }

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 20.dp)
            ) {
                items(mainState.itemsList) { expenseEntity ->
                    ExpenseCard(model = expenseEntity, modifier = Modifier.clickable {
                        navController.navigate("${Screens.AddExpenseScreen.route}/${expenseEntity.id}")
                    }, onDeleteClick = {
                        viewModel.deleteExpenseNote(expenseEntity)
                    })
                }
            }
        }
    }


}
