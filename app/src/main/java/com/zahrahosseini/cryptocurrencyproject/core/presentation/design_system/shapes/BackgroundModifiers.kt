package com.zahrahosseini.cryptocurrencyproject.core.presentation.design_system.shapes

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.zahrahosseini.cryptocurrencyproject.core.presentation.design_system.theme.cryptoCurrencyColors
import com.zahrahosseini.cryptocurrencyproject.core.utils.compose.changeNumberToColor

fun Modifier.bgRounded5ChangeNumber(number: Double) = composed {
    this.then(
        this
            .background(
                shape = RoundedCornerShape(5.dp),
                color = changeNumberToColor(number)
            )
            .padding(5.dp)
            .width(50.dp)
            .wrapContentHeight()
    )
}

fun Modifier.bgRounded5Neutral05StrokePrimary() = composed {
    this.then(
        this
            .clip(RoundedCornerShape(10.dp))
            .background(
                color = MaterialTheme.cryptoCurrencyColors.designSystem.Neutral05
            )
            .border(
                width = 1.dp,
                color = MaterialTheme.cryptoCurrencyColors.designSystem.Primary,
                shape = RoundedCornerShape(10.dp)
            )
    )
}

fun Modifier.bgRounded12Neutral05() = composed {
    this.then(
        this.background(
            shape = RoundedCornerShape(12.dp),
            color = MaterialTheme.cryptoCurrencyColors.designSystem.Neutral05
        )
    )
}