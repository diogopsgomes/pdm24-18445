package com.example.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigation.ui.theme.NavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavigationTheme {
                Column(Modifier.systemBarsPadding()) {
                    var input_text by remember { mutableStateOf(TextFieldValue("")) }

                    NavegacaoApp()
                }
            }
        }
    }
}

@Composable
fun NavegacaoApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "inicio") {
        composable("inicio") {
            EcraInicio(navController)
        }
        composable("destino") {
            EcraDestino()
        }
    }
}

@Composable
fun EcraInicio(navController: NavController) {
    TextField(
        value = input_text,
        onValueChange = { newText ->
            input_text = newText
        }
    )
    Button(onClick = { navController.navigate("destino") }) {
        Text("Ir para o Destino")
    }
}

@Composable
fun EcraDestino() {
    Text(input_text)
}