package com.zahrahosseini.cryptocurrencyproject.core.presentation.design_system.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Red


data class CryptoCurrencyColors(
    val material: ColorScheme,
    val error: Color = Color.Red,
    val designSystem: DesignSystem = DesignSystem(),
    val transparent: Color = Transparent,
)

data class DesignSystem(

    val DefaultPositive: Color = Green,
    val DefaultNegative: Color = Red,

    val Neutral00: Color = Gray00,
    val Neutral05: Color = Gray05,
    val Neutral10: Color = Gray10,
    val Neutral15: Color = Gray15,
    val Neutral20: Color = Gray20,
    val Neutral25: Color = Gray25,
    val Neutral30: Color = Gray30,
    val Neutral35: Color = Gray35,
    val Neutral40: Color = Gray40,
    val Neutral45: Color = Gray45,
    val Neutral50: Color = Gray50,
)


