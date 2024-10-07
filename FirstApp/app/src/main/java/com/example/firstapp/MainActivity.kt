package com.example.firstapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.firstapp.ui.theme.FirstAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FirstAppTheme {
                Login()
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun Login() {
    Column {
        Text(
            text = "Welcome"
        )
        Spacer(
            modifier = Modifier.height(24.dp)
        )
        TextField(
            value = "",
            label = { Text("Email") },
            onValueChange = {}
        )
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        TextField(
            value = "",
            label = { Text("Password") },
            onValueChange = {}
        )
        Spacer(
            modifier = Modifier.height(24.dp)
        )
        Button(
            onClick = {}
        ) {
            Text(
                text = "Entrar"
            )
        }
    }
}