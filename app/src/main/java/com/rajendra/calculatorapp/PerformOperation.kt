package com.rajendra.calculatorapp

sealed class PerformOperation(val symbol: String) {
    object Add: PerformOperation("+")
    object Subtract: PerformOperation("-")
    object Multiply: PerformOperation("x")
    object Divide: PerformOperation("/")
}
