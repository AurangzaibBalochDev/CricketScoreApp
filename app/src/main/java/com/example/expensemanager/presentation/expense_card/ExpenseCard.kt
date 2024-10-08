package com.example.expensemanager.presentation.expense_card

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.expensemanager.data.model.ExpenseEntity
import com.example.expensemanager.presentation.main_screen.components.EntryType
import com.example.expensemanager.ui.theme.CustomColors

//
////@Preview(showSystemUi = true)
//@Composable
//fun ExpenseCard(
//    model: ExpenseEntity,
//    modifier: Modifier = Modifier,
//    onDeleteClick: () -> Unit

//) {
//    Card(
//        modifier = modifier
//            .fillMaxWidth()
//            .padding(10.dp),
//        elevation = CardDefaults.cardElevation(10.dp),
//        colors = CardDefaults.cardColors(CustomColors.dimCardColor)
//    ) {
//
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(horizontal = 15.dp, vertical = 15.dp),
//            horizontalArrangement = Arrangement.SpaceBetween,
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Column(modifier = Modifier, verticalArrangement = Arrangement.Center) {
//
//                Text(text = model.title)
//                Text(text = model.savedTime)
//            }
//
//            Column(modifier = Modifier, verticalArrangement = Arrangement.Center) {
//
//                val myColor: Color = if (model.entryType == EntryType.Expense.name) {
//                    Color.Red
//                } else {
//                    CustomColors.incomeColor
//                }
//                Text(text = model.amount.toString(), color = myColor)
//                Image(
//                    imageVector = Icons.Default.Delete,
//                    contentDescription = "Delete",
//                    modifier = Modifier.clickable {
//                        onDeleteClick()
//                    })
//            }
//        }
//
//    }
//}