package com.example.calculator.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.example.calculator.viewmodels.CalculatorViewModel
import java.util.Locale

@Composable
fun CalculatorScreen(viewModel: CalculatorViewModel) {
    val display by viewModel.display.observeAsState("0")
    val formattedDisplay = if (display.contains(".0")) {
        display.substringBefore(".0")
    } else {
        String.format(Locale.getDefault(),"%.6f", display.toDouble()).trimEnd('0').trimEnd('.')
    }
    Column(
        horizontalAlignment = Alignment.End,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = formattedDisplay,
            fontSize = 60.sp
        )
    }
}