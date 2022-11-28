package com.rajendra.calculatorapp

data class CalculatorState(
    val firstInput: String = "",
    val secondInput: String = "",
    val operation: PerformOperation? = null
)