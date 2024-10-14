package com.example.calculator.models

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

object CalculatorBrain {
    fun add(a: Double, b: Double): Double {
        return a + b
    }

    fun subtract(a: Double, b: Double): Double {
        return a - b
    }

    fun multiply(a: Double, b: Double): Double {
        return a * b
    }

    fun divide(a: Double, b: Double): Double {
        return if (b != 0.0) a / b else Double.NaN
    }

    fun sqrt(a: Double): Double {
        return kotlin.math.sqrt(a)
    }

    fun percent(a: Double): Double {
        return a / 100
    }

    fun negate(a: Double): Double {
        return -a
    }
}