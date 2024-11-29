package com.example.firstapp

import android.os.Bundle
import android.widget.Toast
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
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.firestore.firestore

class MainActivity : ComponentActivity() {
    private lateinit var auth: FirebaseAuth
    val db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        auth = Firebase.auth
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FirstAppTheme {
                Column(
                    modifier = Modifier.systemBarsPadding()
                ) {
                    /*val list = listOf("a", "b", "c")
                    LazyColumnList(list)
                    LazyRowList(list)*/
                    Login()
                }
            }
        }
    }

    fun signUpUser(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Toast.makeText(
                        baseContext,
                        "Authentication succeeded.",
                        Toast.LENGTH_SHORT,
                    ).show()
                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(
                        baseContext,
                        "Authentication failed.",
                        Toast.LENGTH_SHORT,
                    ).show()
                }
            }
    }

    fun signInUser(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Toast.makeText(
                        baseContext,
                        "Authentication succeeded.",
                        Toast.LENGTH_SHORT,
                    ).show()
                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(
                        baseContext,
                        "Authentication failed.",
                        Toast.LENGTH_SHORT,
                    ).show()
                }
            }
    }
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