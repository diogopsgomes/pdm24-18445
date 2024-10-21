package com.example.calculator.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.calculator.models.CalculatorBrain

class CalculatorViewModel : ViewModel() {
    private val _display = MutableLiveData("0")
    val display: LiveData<String> = _display

    private var operand1: Double? = null
    private var operand2: Double? = null
    private var pendingOperation = "="
    private var memory: Double = 0.0
    private var isNewOperand = false

    fun onDigit(digit: String) {
        if (isNewOperand) {
            _display.value = digit
            isNewOperand = false
        } else {
            if (_display.value == "0") {
                _display.value = digit
            } else {
                _display.value += digit
            }
        }
    }

    fun onOperator(operator: String) {
        val value = _display.value?.toDoubleOrNull()
        if (value != null && !isNewOperand) {
            if (operand1 == null) {
                operand1 = value
            } else {
                operand2 = value
                operand1 = CalculatorBrain.calculate(operand1!!, operand2!!, pendingOperation)
                operand2 = null
            }
            _display.value = operand1.toString()
        }
        pendingOperation = operator
        isNewOperand = true
    }

    fun onEquals() {
        val value = _display.value?.toDoubleOrNull()
        if (operand1 != null && value != null) {
            operand2 = value
            _display.value = CalculatorBrain.calculate(operand1!!, operand2!!, pendingOperation).toString()
            operand1 = null
            operand2 = null
            pendingOperation = "="
        }
    }

    fun onClear() {
        _display.value = "0"
        operand1 = null
        operand2 = null
        pendingOperation = "="
        isNewOperand = false
    }

    fun onClearEntry() {
        _display.value = "0"
    }

    fun onMemoryRecall() {
        _display.value = memory.toString()
    }

    fun onMemoryAdd() {
        val value = _display.value?.toDoubleOrNull()
        if (value != null) {
            memory += value
        }
    }

    fun onMemorySubtract() {
        val value = _display.value?.toDoubleOrNull()
        if (value != null) {
            memory -= value
        }
    }

    fun onSquareRoot() {
        val value = _display.value?.toDoubleOrNull()
        if (value != null) {
            _display.value = kotlin.math.sqrt(value).toString()
        }
    }

    fun onPercentage() {
        val value = _display.value?.toDoubleOrNull()
        if (value != null && operand1 != null) {
            _display.value = ((operand1!! * value) / 100).toString()
        } else if (value != null) {
            _display.value = (value / 100).toString()
        }
    }

    fun onPlusMinus() {
        val value = _display.value?.toDoubleOrNull()
        if (value != null) {
            _display.value = (value * -1).toString()
        }
    }
}