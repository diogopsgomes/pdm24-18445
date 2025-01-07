package com.example.store.presentation.view.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.store.presentation.navigation.Screen
import com.example.store.presentation.viewmodel.SignUpViewModel
import com.example.store.utils.AuthState
import kotlinx.coroutines.launch

@Composable
fun SignUpScreen(navController: NavHostController, signUpViewModel: SignUpViewModel) {
    var email by signUpViewModel.email
    var password by signUpViewModel.password
    var nome by signUpViewModel.name

    val coroutineScope = rememberCoroutineScope()
    val authState = signUpViewModel.authState.observeAsState()
    val context = LocalContext.current

    LaunchedEffect(authState.value) {
        when(authState.value) {
            is AuthState.Authenticated -> {
                signUpViewModel.addUser(email, nome)
                navController.navigate(Screen.Home(email))
            }
            is AuthState.Error -> Toast.makeText(
                context,
                (authState.value as AuthState.Error).message,
                Toast.LENGTH_SHORT).show()
            else -> Unit
        }
    }

    Column(
        Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Registar", fontSize = MaterialTheme.typography.headlineSmall.fontSize)
        Spacer(modifier = Modifier.height(24.dp))
        OutlinedTextField(value = email, label = { Text("Email") }, onValueChange = {email = it})
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = password, label = { Text("Palavra-passe") }, onValueChange = {password = it})
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = nome, label = { Text("Nome") }, onValueChange = {nome = it})
        Spacer(modifier = Modifier.height(24.dp))
        Button(colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary), onClick = {
            coroutineScope.launch {
                signUpViewModel.signUp(email,password,context)
            }
        }) {
            Text("Registar")
        }
        Spacer(modifier = Modifier.height(32.dp))
        OutlinedButton(onClick = {
            navController.navigate(Screen.SignIn)
        }) {
            Text("Já tenho conta")
        }
    }
}