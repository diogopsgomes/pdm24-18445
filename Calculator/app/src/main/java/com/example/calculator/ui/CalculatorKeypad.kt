package com.example.calculator.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CalculatorKeypad() {
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