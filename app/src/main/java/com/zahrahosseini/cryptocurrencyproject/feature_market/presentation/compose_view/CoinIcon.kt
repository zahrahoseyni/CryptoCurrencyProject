package com.zahrahosseini.cryptocurrencyproject.feature_market.presentation.compose_view

import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun CoinIcon(
    modifier: Modifier = Modifier,
    imageUrl: String,
    size: Dp = 30.dp,
    shape: Shape = MaterialTheme.shapes.medium
) {
    GlideImage(
        model = imageUrl,
        modifier = modifier
            .size(size)
            .clip(shape = shape),
        contentDescription = null
    )
}