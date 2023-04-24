package com.zahrahosseini.cryptocurrencyproject.core.utils.compose

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.zahrahosseini.cryptocurrencyproject.core.presentation.design_system.theme.cryptoCurrencyColors


@Composable
fun changeNumberToColor(number: Double) : Color {
    return if (number > 0) {
        MaterialTheme.cryptoCurrencyColors.designSystem.DefaultPositive
    } else if (number == 0.0) {
        MaterialTheme.cryptoCurrencyColors.designSystem.Neutral20
    } else{
        MaterialTheme.cryptoCurrencyColors.designSystem.DefaultNegative
    }
}

