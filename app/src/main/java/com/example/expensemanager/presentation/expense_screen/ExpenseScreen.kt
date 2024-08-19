package com.example.expensemanager.presentation.expense_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.expensemanager.ui.theme.CustomColors


@Preview
@Composable
fun ExpenseScreen(
//    navController: NavController,
//    viewModel: MainViewModel = hiltViewModel()
) {
//    val mainState = viewModel.state.collectAsState().value
    Scaffold(

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
                            text = "Total Scores",
                            color = Color.DarkGray,
                            modifier = Modifier.padding(vertical = 5.dp)
                        )
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.Center,
                    ) {
                        Text(text = "150", fontSize = 40.sp)
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
                        Text(text = "Player 1")
                    }
                    Row(
                    ) {
                        Text(text = "Player 2")
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
                        Text(text = "50*", fontSize = 20.sp)
                    }
                    Row(
                    ) {
                        Text(text = "30", fontSize = 20.sp)
                    }
                }


            }


        }
    }


}
