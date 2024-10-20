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
import com.example.calculator.viewmodels.CalculatorViewModel

@Composable
fun CalculatorKeypad(viewModel: CalculatorViewModel) {
    Column(Modifier.fillMaxWidth()) {
        Row(Modifier.fillMaxWidth()) {
            Column(Modifier.weight(1f)) {
                CalculatorButton("MRC", "secondary") { viewModel.onMemoryRecall() }
            }
            Spacer(Modifier.width(5.dp))
            Column(Modifier.weight(1f)) {
                CalculatorButton("M-", "secondary") { viewModel.onMemorySubtract() }
            }
            Spacer(Modifier.width(5.dp))
            Column(Modifier.weight(1f)) {
                CalculatorButton("M+", "secondary") { viewModel.onMemoryAdd() }
            }
            Spacer(Modifier.width(5.dp))
            Column(Modifier.weight(1f)) {
                CalculatorButton("C", "tertiary") { viewModel.onClear() }
            }
        }
        Spacer(Modifier.height(5.dp))
        Row(Modifier.fillMaxWidth()) {
            Column(Modifier.weight(1f)) {
                CalculatorButton("√", "secondary") { viewModel.onSquareRoot() }
            }
            Spacer(Modifier.width(5.dp))
            Column(Modifier.weight(1f)) {
                CalculatorButton("%", "secondary") { viewModel.onPercentage() }
            }
            Spacer(Modifier.width(5.dp))
            Column(Modifier.weight(1f)) {
                CalculatorButton("+/-", "secondary") { viewModel.onPlusMinus() }
            }
            Spacer(Modifier.width(5.dp))
            Column(Modifier.weight(1f)) {
                CalculatorButton("CE", "tertiary") { viewModel.onClearEntry() }
            }
        }
        Spacer(Modifier.height(5.dp))
        Row(Modifier.fillMaxWidth()) {
            Column(Modifier.weight(1f)) {
                CalculatorButton("7", "primary") { viewModel.onDigit("7") }
            }
            Spacer(Modifier.width(5.dp))
            Column(Modifier.weight(1f)) {
                CalculatorButton("8", "primary") { viewModel.onDigit("8") }
            }
            Spacer(Modifier.width(5.dp))
            Column(Modifier.weight(1f)) {
                CalculatorButton("9", "primary") { viewModel.onDigit("9") }
            }
            Spacer(Modifier.width(5.dp))
            Column(Modifier.weight(1f)) {
                CalculatorButton("÷", "secondary") { viewModel.onOperator("÷") }
            }
        }
        Spacer(Modifier.height(5.dp))
        Row(Modifier.fillMaxWidth()) {
            Column(Modifier.weight(1f)) {
                CalculatorButton("4", "primary") { viewModel.onDigit("4") }
            }
            Spacer(Modifier.width(5.dp))
            Column(Modifier.weight(1f)) {
                CalculatorButton("5", "primary") { viewModel.onDigit("5") }
            }
            Spacer(Modifier.width(5.dp))
            Column(Modifier.weight(1f)) {
                CalculatorButton("6", "primary") { viewModel.onDigit("6") }
            }
            Spacer(Modifier.width(5.dp))
            Column(Modifier.weight(1f)) {
                CalculatorButton("×", "secondary") { viewModel.onOperator("×") }
            }
        }
        Spacer(Modifier.height(5.dp))
        Row(Modifier.fillMaxWidth()) {
            Column(Modifier.weight(1f)) {
                CalculatorButton("1", "primary") { viewModel.onDigit("1") }
            }
            Spacer(Modifier.width(5.dp))
            Column(Modifier.weight(1f)) {
                CalculatorButton("2", "primary") { viewModel.onDigit("2") }
            }
            Spacer(Modifier.width(5.dp))
            Column(Modifier.weight(1f)) {
                CalculatorButton("3", "primary") { viewModel.onDigit("3") }
            }
            Spacer(Modifier.width(5.dp))
            Column(Modifier.weight(1f)) {
                CalculatorButton("-", "secondary") { viewModel.onOperator("-") }
            }
        }
        Spacer(Modifier.height(5.dp))
        Row(Modifier.fillMaxWidth()) {
            Column(Modifier.weight(1f)) {
                CalculatorButton("0", "primary") { viewModel.onDigit("0") }
            }
            Spacer(Modifier.width(5.dp))
            Column(Modifier.weight(1f)) {
                CalculatorButton(".", "primary") { viewModel.onDigit(".") }
            }
            Spacer(Modifier.width(5.dp))
            Column(Modifier.weight(1f)) {
                CalculatorButton("=", "primary") { viewModel.onEquals() }
            }
            Spacer(Modifier.width(5.dp))
            Column(Modifier.weight(1f)) {
                CalculatorButton("+", "secondary") { viewModel.onOperator("+") }
            }
        }
    }
}