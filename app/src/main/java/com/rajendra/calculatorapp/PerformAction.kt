package com.rajendra.calculatorapp

sealed class PerformAction {
    data class Number(val number: Int): PerformAction()
    object Clear: PerformAction()
    object Delete: PerformAction()
    data class Operation(val operation: PerformOperation): PerformAction()
    object Calculate: PerformAction()
    object Decimal: PerformAction()
}