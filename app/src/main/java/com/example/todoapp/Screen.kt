package com.example.todoapp

sealed class Screen(val route: String, val sTitle: String){
    object homeScreen: Screen("homeScreen", "Task list")
    object newTastScreen: Screen("newTaskScreen", "Create new task")
}