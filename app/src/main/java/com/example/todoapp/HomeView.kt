package com.example.todoapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.todoapp.data.test

@Composable
fun HomeView(viewModel: ToDoViewModel){
    Text(text = "main view work")
    LazyColumn(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.surface)
            .fillMaxSize()
    ){
        items(test.testList){
            item ->
            ToDoItemView(toDoItem = item)
        }
    }
}