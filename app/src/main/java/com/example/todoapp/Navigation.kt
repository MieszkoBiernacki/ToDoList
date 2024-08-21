package com.example.todoapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.Navigator
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation(
    viewModel: ToDoViewModel,
    navController: NavHostController
){
    NavHost(navController = navController, startDestination = Screen.homeScreen.route) {
        composable(Screen.homeScreen.route){
            HomeView(viewModel = viewModel)
        }

        composable(Screen.newTastScreen.route){
            NewTaskView(viewModel = viewModel, controller = navController)
        }
    }
}