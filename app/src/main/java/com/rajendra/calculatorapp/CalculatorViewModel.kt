package com.rajendra.calculatorapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalculatorViewModel: ViewModel() {

    var state by mutableStateOf(CalculatorState())

    fun userAction(action: PerformAction) {
        when(action) {
            is PerformAction.Number -> enterNumber(action.number)
            is PerformAction.Delete -> delete()
            is PerformAction.Clear -> state = CalculatorState()
            is PerformAction.Operation -> enterOperation(action.operation)
            is PerformAction.Decimal -> enterDecimal()
            is PerformAction.Calculate -> calculate()
        }
    }

    private fun enterOperation(operation: PerformOperation) {
        if(state.firstInput.isNotBlank()) {
            state = state.copy(operation = operation)
        }
    }

    private fun calculate() {
        val number1 = state.firstInput.toDoubleOrNull()
        val number2 = state.secondInput.toDoubleOrNull()
        if(number1 != null && number2 != null) {
            val result = when(state.operation) {
                is PerformOperation.Add -> number1 + number2
                is PerformOperation.Subtract -> number1 - number2
                is PerformOperation.Multiply -> number1 * number2
                is PerformOperation.Divide -> number1 / number2
                null -> return
            }
            state = state.copy(
                firstInput = result.toString().take(15),
                secondInput = "",
                operation = null
            )
        }
    }

    private fun delete() {
        when {
            state.secondInput.isNotBlank() -> state = state.copy(
                secondInput = state.secondInput.dropLast(1)
            )
            state.operation != null -> state = state.copy(
                operation = null
            )
            state.firstInput.isNotBlank() -> state = state.copy(
                firstInput = state.firstInput.dropLast(1)
            )
        }
    }

    private fun enterDecimal() {
        if(state.operation == null && !state.firstInput.contains(".") && state.firstInput.isNotBlank()) {
            state = state.copy(
                firstInput = state.firstInput + "."
            )
            return
        } else if(!state.secondInput.contains(".") && state.secondInput.isNotBlank()) {
            state = state.copy(
                secondInput = state.secondInput + "."
            )
        }
    }

    private fun enterNumber(number: Int) {
        if(state.operation == null) {
            if(state.firstInput.length >= MAX_NUM_LENGTH) {
                return
            }
            state = state.copy(
                firstInput = state.firstInput + number
            )
            return
        }
        if(state.secondInput.length >= MAX_NUM_LENGTH) {
            return
        }
        state = state.copy(
            secondInput = state.secondInput + number
        )
    }

    companion object {
        private const val MAX_NUM_LENGTH = 8
    }
}