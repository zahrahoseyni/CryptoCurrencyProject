package com.zahrahosseini.cryptocurrencyproject.feature_market.presentation.compose_view

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.zahrahosseini.cryptocurrencyproject.core.presentation.design_system.theme.cryptoCurrencyColors

@Composable
fun MarketItemList() {

    ConstraintLayout() {

        val (imgLogo, txtSymbol, txtName, ttxChangePercent, txtPrice, txtVolume) = createRefs()

        CoinIcon(imageUrl = "https://en.wikipedia.org/wiki/Bitcoin#/media/File:Bitcoin.svg",
            modifier = Modifier
                .constrainAs(imgLogo) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                })

        Text(
            text = "Bitcoin",
            color = MaterialTheme.cryptoCurrencyColors.designSystem.Neutral45,
            style = TextStyle(fontWeight = FontWeight.Medium, fontSize = 14.sp),
            modifier = Modifier.constrainAs(txtName) {
                bottom.linkTo(imgLogo.bottom)
                end.linkTo(imgLogo.start)
            }
        )

        Text(
            text = "BTC",
            color = MaterialTheme.cryptoCurrencyColors.designSystem.Neutral45,
            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 16.sp),
            modifier = Modifier.constrainAs(txtName) {
                top.linkTo(imgLogo.top)
                end.linkTo(imgLogo.start)
            }
        )


    }
}


@Preview(showBackground = true)
@Composable
fun Preview() {
    MarketItemList()
}