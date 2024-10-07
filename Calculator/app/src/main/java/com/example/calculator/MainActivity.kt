package com.example.calculator

import android.os.Bundle
import android.view.Display
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculator.ui.theme.CalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var displayValue by remember { mutableStateOf("0") }

            CalculatorTheme() {
                Column(Modifier.systemBarsPadding().fillMaxSize().padding(15.dp), verticalArrangement = Arrangement.Bottom) {
                    CalculatorDisplay(text = displayValue)
                    Spacer(Modifier.height(15.dp))
                    CalculatorKeyboard()
                }
            }
        }
    }
}

@Composable
fun CalculatorDisplay(text: String) {
    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.End) {
        Text(
            text = text,
            fontSize = 60.sp
        )
    }
}

@Composable
fun CalculatorKeyboard() {
    Column(Modifier.fillMaxWidth()) {
        Row(Modifier.fillMaxWidth()) {
            Column(Modifier.weight(1f)) {
                CalculatorButton("MRC", "secondary", {})
            }
            Spacer(Modifier.width(5.dp))
            Column(Modifier.weight(1f)) {
                CalculatorButton("M-", "secondary", {})
            }
            Spacer(Modifier.width(5.dp))
            Column(Modifier.weight(1f)) {
                CalculatorButton("M+", "secondary", {})
            }
            Spacer(Modifier.width(5.dp))
            Column(Modifier.weight(1f)) {
                CalculatorButton("C", "tertiary", {})
            }
        }
        Spacer(Modifier.height(5.dp))
        Row(Modifier.fillMaxWidth()) {
            Column(Modifier.weight(1f)) {
                CalculatorButton("√", "secondary", {})
            }
            Spacer(Modifier.width(5.dp))
            Column(Modifier.weight(1f)) {
                CalculatorButton("%", "secondary", {})
            }
            Spacer(Modifier.width(5.dp))
            Column(Modifier.weight(1f)) {
                CalculatorButton("+/-", "secondary", {})
            }
            Spacer(Modifier.width(5.dp))
            Column(Modifier.weight(1f)) {
                CalculatorButton("CE", "tertiary", {})
            }
        }
        Spacer(Modifier.height(5.dp))
        Row(Modifier.fillMaxWidth()) {
            Column(Modifier.weight(1f)) {
                CalculatorButton("7", "primary", {})
            }
            Spacer(Modifier.width(5.dp))
            Column(Modifier.weight(1f)) {
                CalculatorButton("8", "primary", {})
            }
            Spacer(Modifier.width(5.dp))
            Column(Modifier.weight(1f)) {
                CalculatorButton("9", "primary", {})
            }
            Spacer(Modifier.width(5.dp))
            Column(Modifier.weight(1f)) {
                CalculatorButton("÷", "secondary", {})
            }
        }
        Spacer(Modifier.height(5.dp))
        Row(Modifier.fillMaxWidth()) {
            Column(Modifier.weight(1f)) {
                CalculatorButton("4", "primary", {})
            }
            Spacer(Modifier.width(5.dp))
            Column(Modifier.weight(1f)) {
                CalculatorButton("5", "primary", {})
            }
            Spacer(Modifier.width(5.dp))
            Column(Modifier.weight(1f)) {
                CalculatorButton("6", "primary", {})
            }
            Spacer(Modifier.width(5.dp))
            Column(Modifier.weight(1f)) {
                CalculatorButton("×", "secondary", {})
            }
        }
        Spacer(Modifier.height(5.dp))
        Row(Modifier.fillMaxWidth()) {
            Column(Modifier.weight(1f)) {
                CalculatorButton("1", "primary", {})
            }
            Spacer(Modifier.width(5.dp))
            Column(Modifier.weight(1f)) {
                CalculatorButton("2", "primary", {})
            }
            Spacer(Modifier.width(5.dp))
            Column(Modifier.weight(1f)) {
                CalculatorButton("3", "primary", {})
            }
            Spacer(Modifier.width(5.dp))
            Column(Modifier.weight(1f)) {
                CalculatorButton("-", "secondary", {})
            }
        }
        Spacer(Modifier.height(5.dp))
        Row(Modifier.fillMaxWidth()) {
            Column(Modifier.weight(1f)) {
                CalculatorButton("0", "primary", {})
            }
            Spacer(Modifier.width(5.dp))
            Column(Modifier.weight(1f)) {
                CalculatorButton(".", "primary", {})
            }
            Spacer(Modifier.width(5.dp))
            Column(Modifier.weight(1f)) {
                CalculatorButton("=", "primary", {})
            }
            Spacer(Modifier.width(5.dp))
            Column(Modifier.weight(1f)) {
                CalculatorButton("+", "secondary", {})
            }
        }
    }
}

@Composable
fun CalculatorButton(text: String, color: String, onClick: () -> Unit) {
    val buttonColor = when (color.lowercase()) {
        "primary" -> Color.Gray
        "secondary" -> Color.Black
        "tertiary" -> Color.Red
        else -> Color.Gray
    }

    Button(
        onClick = onClick,
        colors = ButtonColors(
            containerColor = buttonColor,
            contentColor = Color.White,
            disabledContainerColor = Color.Gray,
            disabledContentColor = Color.White
        ),
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(11/10f)
    ) {
        Text(
            text = text,
            fontSize = 20.sp
        )
    }
}