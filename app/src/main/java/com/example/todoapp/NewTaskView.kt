package com.example.todoapp

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@SuppressLint("UnrememberedMutableState")
@Composable
fun NewTaskView(viewModel: ToDoViewModel, controller: NavHostController){
    var titleInput by remember { mutableStateOf("") }
    var descInput by remember { mutableStateOf("") }
    Column (
        modifier = Modifier
            .background(MaterialTheme.colorScheme.surface)
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ){
        Column {
            OutlinedTextField(
                value = titleInput,
                onValueChange = {
                    titleInput = it
                },
                label = {
                    Text(text = "Task Name")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                singleLine = true
            )
            OutlinedTextField(
                value = descInput,
                onValueChange = { descInput = it },
                label = { Text(text = "Task Description")},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
        }
        Button(
            onClick = {
                /* TODO - add item*/
                controller.navigate(Screen.homeScreen.route)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondaryContainer)
        ) {
            Text(
                text = "Add",
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                fontSize = 20.sp,
                fontWeight = FontWeight.W600
                )
        }
    }
}