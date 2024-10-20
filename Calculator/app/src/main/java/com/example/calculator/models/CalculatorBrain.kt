package com.example.calculator.models

object CalculatorBrain {
    fun calculate(operand1: Double, operand2: Double, operator: String): Double {
        return when (operator) {
            "+" -> operand1 + operand2
            "-" -> operand1 - operand2
            "×" -> operand1 * operand2
            "÷" -> operand1 / operand2
            else -> operand2
        }
    }
}