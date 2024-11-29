package com.example.firstapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.firstapp.ui.theme.FirstAppTheme
import java.text.Normalizer.Form

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FirstAppTheme {
                Column(
                    modifier = Modifier.systemBarsPadding()
                ) {
                    val list = listOf("a", "b", "c")
                    LazyColumnList(list)
                    LazyRowList(list)
                }
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

@Composable
fun LazyColumnList(itemsList: List<String>) {
    LazyColumn {
        items(itemsList) { item ->
            Text(text = item)
        }
    }
}

@Composable
fun LazyRowList(itemsList: List<String>) {
    LazyRow {
        items(itemsList) { item ->
            Text(text = item)
        }
    }
}

@Composable
fun Form(itemsList: List<FormLine>) {
    LazyColumn {
        items(itemsList) { item ->
            Row {
                Text(text = item.Name)
                TextField(
                    value = "",
                    placeholder = { item.Hint?.let { Text(text = it) } },
                    onValueChange = {}
                )
            }
        }
    }
}