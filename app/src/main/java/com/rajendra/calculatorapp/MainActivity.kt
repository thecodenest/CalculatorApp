package com.rajendra.calculatorapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.rajendra.calculatorapp.ui.theme.CalculatorAppTheme
import com.rajendra.calculatorapp.ui.theme.LightGray
import com.rajendra.calculatorapp.ui.theme.MediumGray
import com.rajendra.calculatorapp.ui.theme.Orange

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorAppTheme {
                val viewModel = viewModel<CalculatorViewModel>()
                val state = viewModel.state
                val buttonSpacing = 8.dp
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.DarkGray)
                        .padding(16.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.BottomCenter),
                        verticalArrangement = Arrangement.spacedBy(buttonSpacing),
                    ) {
                        Text(
                            text = state.firstInput + (state.operation?.symbol
                                ?: "") + state.secondInput,
                            textAlign = TextAlign.End,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 32.dp),
                            fontWeight = FontWeight.Light,
                            fontSize = 80.sp,
                            color = Color.White,
                            maxLines = 2
                        )
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                        ) {
                            CalculatorButton(
                                symbol = "Clear",
                                color = LightGray,
                                modifier = Modifier
                                    .aspectRatio(2f)
                                    .weight(2f)
                            ) {
                                viewModel.userAction(PerformAction.Clear)
                            }
                            CalculatorButton(
                                symbol = "Del",
                                color = LightGray,
                                modifier = Modifier
                                    .aspectRatio(1f)
                                    .weight(1f)
                            ) {
                                viewModel.userAction(PerformAction.Delete)
                            }
                            CalculatorButton(
                                symbol = "/",
                                color = Orange,
                                modifier = Modifier
                                    .aspectRatio(1f)
                                    .weight(1f)
                            ) {
                                viewModel.userAction(PerformAction.Operation(PerformOperation.Divide))
                            }
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                        ) {
                            CalculatorButton(
                                symbol = "7",
                                color = MediumGray,
                                modifier = Modifier
                                    .aspectRatio(1f)
                                    .weight(1f)
                            ) {
                                viewModel.userAction(PerformAction.Number(7))
                            }
                            CalculatorButton(
                                symbol = "8",
                                color = MediumGray,
                                modifier = Modifier
                                    .aspectRatio(1f)
                                    .weight(1f)
                            ) {
                                viewModel.userAction(PerformAction.Number(8))
                            }
                            CalculatorButton(
                                symbol = "9",
                                color = MediumGray,
                                modifier = Modifier
                                    .aspectRatio(1f)
                                    .weight(1f)
                            ) {
                                viewModel.userAction(PerformAction.Number(9))
                            }
                            CalculatorButton(
                                symbol = "x",
                                color = Orange,
                                modifier = Modifier
                                    .aspectRatio(1f)
                                    .weight(1f)
                            ) {
                                viewModel.userAction(PerformAction.Operation(PerformOperation.Multiply))
                            }
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                        ) {
                            CalculatorButton(
                                symbol = "4",
                                color = MediumGray,
                                modifier = Modifier
                                    .aspectRatio(1f)
                                    .weight(1f)
                            ) {
                                viewModel.userAction(PerformAction.Number(4))
                            }
                            CalculatorButton(
                                symbol = "5",
                                color = MediumGray,
                                modifier = Modifier
                                    .aspectRatio(1f)
                                    .weight(1f)
                            ) {
                                viewModel.userAction(PerformAction.Number(5))
                            }
                            CalculatorButton(
                                symbol = "6",
                                color = MediumGray,
                                modifier = Modifier
                                    .aspectRatio(1f)
                                    .weight(1f)
                            ) {
                                viewModel.userAction(PerformAction.Number(6))
                            }
                            CalculatorButton(
                                symbol = "-",
                                color = Orange,
                                modifier = Modifier
                                    .aspectRatio(1f)
                                    .weight(1f)
                            ) {
                                viewModel.userAction(PerformAction.Operation(PerformOperation.Subtract))
                            }
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                        ) {
                            CalculatorButton(
                                symbol = "1",
                                color = MediumGray,
                                modifier = Modifier
                                    .aspectRatio(1f)
                                    .weight(1f)
                            ) {
                                viewModel.userAction(PerformAction.Number(1))
                            }
                            CalculatorButton(
                                symbol = "2",
                                color = MediumGray,
                                modifier = Modifier
                                    .aspectRatio(1f)
                                    .weight(1f)
                            ) {
                                viewModel.userAction(PerformAction.Number(2))
                            }
                            CalculatorButton(
                                symbol = "3",
                                color = MediumGray,
                                modifier = Modifier
                                    .aspectRatio(1f)
                                    .weight(1f)
                            ) {
                                viewModel.userAction(PerformAction.Number(3))
                            }
                            CalculatorButton(
                                symbol = "+",
                                color = Orange,
                                modifier = Modifier
                                    .aspectRatio(1f)
                                    .weight(1f)
                            ) {
                                viewModel.userAction(PerformAction.Operation(PerformOperation.Add))
                            }
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                        ) {
                            CalculatorButton(
                                symbol = "0",
                                color = MediumGray,
                                modifier = Modifier
                                    .aspectRatio(2f)
                                    .weight(2f)
                            ) {
                                viewModel.userAction(PerformAction.Number(0))
                            }
                            CalculatorButton(
                                symbol = ".",
                                color = MediumGray,
                                modifier = Modifier
                                    .aspectRatio(1f)
                                    .weight(1f)
                            ) {
                                viewModel.userAction(PerformAction.Decimal)
                            }
                            CalculatorButton(
                                symbol = "=",
                                color = Orange,
                                modifier = Modifier
                                    .aspectRatio(1f)
                                    .weight(1f)
                            ) {
                                viewModel.userAction(PerformAction.Calculate)
                            }
                        }
                    }
                }
            }
        }
    }
}