package com.zahrahosseini.cryptocurrencyproject.core.presentation.design_system.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf


private val LightColorPalette = CryptoCurrencyColors(
    material = lightColorScheme(
        // You can override default colors
    ),
)

private val DarkColorPalette = CryptoCurrencyColors(
    material = darkColorScheme(
        // You can override default colors
    )
)


@Composable
fun CryptoCurrencyTheme(
    content: @Composable () -> Unit,
) {

    CompositionLocalProvider(
        LocalColors provides LightColorPalette
    ) {
        MaterialTheme(
            colorScheme = LightColorPalette.material,
            content = content,
        )
    }
}


private val LocalColors = staticCompositionLocalOf { LightColorPalette }

val MaterialTheme.cryptoCurrencyColors: CryptoCurrencyColors
    @Composable
    @ReadOnlyComposable
    get() = LocalColors.current
