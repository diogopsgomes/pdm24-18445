package com.example.calculator.ui

import android.service.autofill.OnClickAction
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

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