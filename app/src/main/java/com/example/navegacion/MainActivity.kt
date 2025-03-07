package com.example.navegacion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppNavigation()
        }
    }
}

class ContadorViewModel : ViewModel() {
    private val _counter = MutableStateFlow(0)
    val counter: StateFlow<Int> = _counter

    fun increment() {
        _counter.value++
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val viewModel: ContadorViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = "contador"
    ) {
        composable("contador") { ContadorScreen(navController, viewModel) }
        composable("resultado") { ResultadoScreen(viewModel) }
    }
}

@Composable
fun ContadorScreen(navController: NavController, viewModel: ContadorViewModel) {
    val counter by viewModel.counter.collectAsState()

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextButton(onClick = { viewModel.increment() }) {
                Text("CLICS: $counter")
            }
            Spacer(Modifier.size(16.dp))
            OutlinedButton(
                onClick = { navController.navigate("resultado") }
            ) {
                Text("INFORMAR")
            }
        }
    }
}

@Composable
fun ResultadoScreen(viewModel: ContadorViewModel) {
    val counter by viewModel.counter.collectAsState()

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Total de clics: $counter")
        }
    }
}






