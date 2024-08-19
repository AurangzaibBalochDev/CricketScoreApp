package com.example.expensemanager.presentation.add_expense_manager

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.expensemanager.presentation.main_screen.components.EntryType
import com.example.expensemanager.presentation.text_field.MyTextField
import com.example.expensemanager.ui.theme.CustomColors


@Composable
fun AddExpenseScreen(
    id: String,
    navController: NavController,
    viewModel: AddExpenseViewModel = hiltViewModel()
) {
    LaunchedEffect(Unit) {
        if (id.toInt() != -1) {
            viewModel.getTheDataById(id)
        }
    }

    val state = viewModel.state.collectAsState().value

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 15.dp, vertical = 15.dp
                )
                .align(Alignment.Center),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(text = "Title")
            MyTextField(
                value = state.title,
                onValueChange = { viewModel.onTitleChanged(it) })

            Spacer(modifier = Modifier.height(10.dp))

            Text(text = "Amount")

            MyTextField(
                value = state.title,
                onValueChange = { viewModel.onAmountChanged(it) })
            Text("Select an option:")

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .selectableGroup(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = state.selected == EntryType.Expense,
                    onClick = {
                        viewModel.select(EntryType.Expense)
                    },
                    modifier = Modifier.padding(8.dp)
                )
                Text("Expense", modifier = Modifier.padding(start = 8.dp))

                RadioButton(
                    selected = state.selected == EntryType.Income,
                    onClick = {
                        viewModel.select(EntryType.Income)
                    },
                    modifier = Modifier.padding(8.dp)
                )
                Text("Income", modifier = Modifier.padding(start = 8.dp))
            }
            Button(
                onClick = {
                    if (id.toInt() != -1) {
                        viewModel.onUpdateItem()
                        navController.popBackStack()
                    } else {
                        viewModel.onSaveItem()
                        navController.popBackStack()
                    }
                },
                colors = ButtonDefaults.buttonColors(CustomColors.mainCardColor),
                shape = RoundedCornerShape(5.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.Center,
                ) {

                    Text(
                        text = "Save",
                    )
                }
            }
        }
    }
}