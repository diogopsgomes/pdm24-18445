package com.example.store.presentation.view.screens

import android.util.Log
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.store.domain.model.UserAuth
import com.example.store.presentation.navigation.Screen
import com.example.store.presentation.viewmodel.SignInViewModel
import com.example.store.utils.AuthState
import com.example.store.utils.showToast
import kotlinx.coroutines.launch

@Composable
fun SignInScreen(navController: NavHostController, signInViewModel: SignInViewModel) {
    val coroutineScope = rememberCoroutineScope()
    val authState = signInViewModel.authState.observeAsState()
    val context = LocalContext.current
    var user by remember { mutableStateOf<UserAuth?>(null) }

    LaunchedEffect(authState.value) {
        when(authState.value){
            is AuthState.Authenticated -> {
                if (user == null) {
                    Log.d("Teste", "Antes da rota home, user = null")
                } else{
                    Log.d("Teste", "Antes da rota home, user != null")
                }

                navController.navigate(Screen.Home(user!!.email))
            }
            is AuthState.Error -> showToast(context,(authState.value as AuthState.Error).message)
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
        Text(text = "Entrar", fontSize = MaterialTheme.typography.headlineSmall.fontSize)
        Spacer(modifier = Modifier.height(24.dp))
        OutlinedTextField(value = signInViewModel.email.value, label = { Text("Email") }, onValueChange = {signInViewModel.email.value = it})
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = signInViewModel.password.value, label = { Text("Palavra-passe") }, onValueChange = {signInViewModel.password.value = it})
        Spacer(modifier = Modifier.height(24.dp))
        Button(colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary), onClick = {
            coroutineScope.launch {
                user = signInViewModel.signIn(signInViewModel.email.value,signInViewModel.password.value,context)
            }
        }) {
            Text("Entrar")
        }
        Spacer(modifier = Modifier.height(32.dp))
        OutlinedButton(onClick = {
            navController.navigate(Screen.SignUp)
        }) {
            Text("Não tenho conta")
        }
    }
}