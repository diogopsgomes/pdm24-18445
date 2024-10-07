package com.example.calculator

import android.os.Bundle
import android.view.Display
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
            CalculatorTheme() {
                Column(Modifier.systemBarsPadding().fillMaxSize().padding(15.dp), verticalArrangement = Arrangement.Bottom) {
                    CalculatorDisplay()
                    Spacer(Modifier.height(15.dp))
                    CalculatorKeyboard()
                }
            }
        }
    }
}

@Composable
fun CalculatorDisplay() {
    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.End) {
        Text(
            text = "1",
            fontSize = 60.sp
        )
    }
}

@Composable
fun CalculatorKeyboard() {
    Column(Modifier.fillMaxWidth()) {
        Row(Modifier.fillMaxWidth()) {
            Column(Modifier.weight(1f)) {
                CalculatorButton("MRC", {})
            }
            Spacer(Modifier.width(5.dp))
            Column(Modifier.weight(1f)) {
                CalculatorButton("M-", {})
            }
            Spacer(Modifier.width(5.dp))
            Column(Modifier.weight(1f)) {
                CalculatorButton("M+", {})
            }
            Spacer(Modifier.width(5.dp))
            Column(Modifier.weight(1f)) {
                CalculatorButton("C", {})
            }
        }
        Spacer(Modifier.height(5.dp))
        Row(Modifier.fillMaxWidth()) {
            Column(Modifier.weight(1f)) {
                CalculatorButton("√", {})
            }
            Spacer(Modifier.width(5.dp))
            Column(Modifier.weight(1f)) {
                CalculatorButton("%", {})
            }
            Spacer(Modifier.width(5.dp))
            Column(Modifier.weight(1f)) {
                CalculatorButton("+/-", {})
            }
            Spacer(Modifier.width(5.dp))
            Column(Modifier.weight(1f)) {
                CalculatorButton("CE", {})
            }
        }
        Spacer(Modifier.height(5.dp))
        Row(Modifier.fillMaxWidth()) {
            Column(Modifier.weight(1f)) {
                CalculatorButton("7", {})
            }
            Spacer(Modifier.width(5.dp))
            Column(Modifier.weight(1f)) {
                CalculatorButton("8", {})
            }
            Spacer(Modifier.width(5.dp))
            Column(Modifier.weight(1f)) {
                CalculatorButton("9", {})
            }
            Spacer(Modifier.width(5.dp))
            Column(Modifier.weight(1f)) {
                CalculatorButton("÷", {})
            }
        }
        Spacer(Modifier.height(5.dp))
        Row(Modifier.fillMaxWidth()) {
            Column(Modifier.weight(1f)) {
                CalculatorButton("4", {})
            }
            Spacer(Modifier.width(5.dp))
            Column(Modifier.weight(1f)) {
                CalculatorButton("5", {})
            }
            Spacer(Modifier.width(5.dp))
            Column(Modifier.weight(1f)) {
                CalculatorButton("6", {})
            }
            Spacer(Modifier.width(5.dp))
            Column(Modifier.weight(1f)) {
                CalculatorButton("×", {})
            }
        }
        Spacer(Modifier.height(5.dp))
        Row(Modifier.fillMaxWidth()) {
            Column(Modifier.weight(1f)) {
                CalculatorButton("1", {})
            }
            Spacer(Modifier.width(5.dp))
            Column(Modifier.weight(1f)) {
                CalculatorButton("2", {})
            }
            Spacer(Modifier.width(5.dp))
            Column(Modifier.weight(1f)) {
                CalculatorButton("3", {})
            }
            Spacer(Modifier.width(5.dp))
            Column(Modifier.weight(1f)) {
                CalculatorButton("-", {})
            }
        }
        Spacer(Modifier.height(5.dp))
        Row(Modifier.fillMaxWidth()) {
            Column(Modifier.weight(1f)) {
                CalculatorButton("0", {})
            }
            Spacer(Modifier.width(5.dp))
            Column(Modifier.weight(1f)) {
                CalculatorButton(".", {})
            }
            Spacer(Modifier.width(5.dp))
            Column(Modifier.weight(1f)) {
                CalculatorButton("=", {})
            }
            Spacer(Modifier.width(5.dp))
            Column(Modifier.weight(1f)) {
                CalculatorButton("+", {})
            }
        }
    }
}

@Composable
fun CalculatorButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        Modifier.fillMaxWidth()
                .aspectRatio(1f)
    ) {
        Text(
            text = text,
            fontSize = 20.sp
        )
    }
}