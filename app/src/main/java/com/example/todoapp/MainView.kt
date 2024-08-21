package com.example.todoapp


import android.annotation.SuppressLint
import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainView(viewModel: ToDoViewModel, controller: NavController){

    val scaffoldState: ScaffoldState = rememberScaffoldState()
    val scope: CoroutineScope = rememberCoroutineScope()

    Scaffold (
        scaffoldState = scaffoldState,
        modifier = Modifier.fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surfaceContainer
                ),
                title = {
                    Text(
                        text = "Task list",
                        maxLines = 1,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        scope.launch { scaffoldState.drawerState.open() }
                    }) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = "Localized description",
                            tint = MaterialTheme.colorScheme.onSurface
                        )
                    }
                },
                actions = {
                    
                    IconButton(onClick = {
                        controller.navigate(Screen.newTastScreen.route)
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Filled.AddCircle,
                            contentDescription = "Localized description",
                            tint = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
            )
        },
        drawerContent = {
            Column (
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.surfaceContainer)
                    .fillMaxSize()
                    .padding(16.dp)
            ){
                Spacer(modifier = Modifier.height(30.dp))
                Row (modifier = Modifier
                    .padding(8.dp)
                    .clickable {  }
                    .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.history),
                            contentDescription = "Localized description",
                            tint = MaterialTheme.colorScheme.onSurface
                        )
                    }
                    Text(text = "History")
                }
                Row (modifier = Modifier
                    .padding(8.dp)
                    .clickable {  }
                    .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.clear),
                            contentDescription = "Localized description",
                            tint = MaterialTheme.colorScheme.onSurface
                        )
                    }
                    Text(text = "Clear all")
                }
            }
        }
    ){
        Navigation(viewModel = viewModel, controller as NavHostController)
    }
}
