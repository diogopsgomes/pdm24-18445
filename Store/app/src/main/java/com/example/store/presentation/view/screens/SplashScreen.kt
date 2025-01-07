package com.example.store.presentation.view.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.store.presentation.navigation.Screen
import com.example.store.presentation.viewmodel.SplashViewModel

@Composable
fun SplashScreen(viewModel: SplashViewModel, navController: NavHostController) {
    val isAuthenticated = viewModel.isAuthenticated.collectAsState()

    LaunchedEffect(isAuthenticated.value) {
        if (isAuthenticated.value != "") {
            navController.navigate(Screen.Home(isAuthenticated.value))
        } else {
            navController.navigate(Screen.SignIn)
        }
    }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator()
    }
}