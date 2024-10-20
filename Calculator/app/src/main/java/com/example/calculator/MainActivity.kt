package com.example.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.example.calculator.ui.CalculatorBody
import com.example.calculator.ui.theme.CalculatorTheme
import com.example.calculator.viewmodels.CalculatorViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculatorTheme() {
                val viewModel: CalculatorViewModel by viewModels()
                CalculatorBody(viewModel)
            }
        }
    }
}