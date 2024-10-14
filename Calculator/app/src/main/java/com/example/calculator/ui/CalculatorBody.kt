package com.example.calculator.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.example.calculator.viewmodels.CalculatorViewModel

@Composable
fun CalculatorBody(viewModel: CalculatorViewModel) {
    var displayValue by remember { mutableStateOf("0") }

    Column(
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier
            .systemBarsPadding()
            .fillMaxSize()
            .padding(15.dp)
    ) {
        CalculatorScreen(value = displayValue)
        Spacer(Modifier.height(15.dp))
        CalculatorKeypad()
    }
}