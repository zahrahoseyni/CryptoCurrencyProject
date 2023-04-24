package com.zahrahosseini.cryptocurrencyproject.feature_market.presentation.compose_view

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.zahrahosseini.cryptocurrencyproject.core.presentation.design_system.shapes.bgRounded5ChangeNumber
import com.zahrahosseini.cryptocurrencyproject.core.presentation.design_system.theme.cryptoCurrencyColors
import com.zahrahosseini.cryptocurrencyproject.feature_market.domain.entity.CoinListResponse

@Composable
fun MarketItemList(coin: CoinListResponse) {

    ConstraintLayout(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .wrapContentHeight()
    ) {

        val (imgLogo, txtSymbol, txtName, txChangePercent, txtPrice, txtVolume) = createRefs()

        CoinIcon(imageUrl = "https://pngimg.com/uploads/bitcoin/bitcoin_PNG48.png",
            modifier = Modifier
                .constrainAs(imgLogo) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                })


        Text(
            text = coin.nameFa,
            color = MaterialTheme.cryptoCurrencyColors.designSystem.Neutral35,
            style = TextStyle(fontWeight = FontWeight.Normal, fontSize = 16.sp),
            modifier = Modifier.constrainAs(txtName) {
                top.linkTo(txtSymbol.bottom)
                end.linkTo(imgLogo.start, 8.dp)
            }
        )

        Text(
            text = coin.symbol,
            color = MaterialTheme.cryptoCurrencyColors.designSystem.Neutral45,
            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 16.sp),
            modifier = Modifier.constrainAs(txtSymbol) {
                top.linkTo(parent.top)
                end.linkTo(imgLogo.start, 8.dp)
            }
        )

        Text(
            text = "${coin.usdtVolume} USDT",
            color = MaterialTheme.cryptoCurrencyColors.designSystem.Neutral45,
            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 16.sp),
            modifier = Modifier.constrainAs(txtVolume) {
                top.linkTo(parent.top)
                start.linkTo(txChangePercent.end, 8.dp)
            }
        )


        Text(
            text = "${coin.priceInUsdt} تومان",
            color = MaterialTheme.cryptoCurrencyColors.designSystem.Neutral35,
            style = TextStyle(fontWeight = FontWeight.Normal, fontSize = 16.sp),
            modifier = Modifier.constrainAs(txtPrice) {
                top.linkTo(txtVolume.bottom, 5.dp)
                start.linkTo(txChangePercent.end, 8.dp)
            }
        )


        Text(
            text = "${coin.changePercent}%",
            color = MaterialTheme.cryptoCurrencyColors.designSystem.Neutral00,
            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 16.sp),
            modifier = Modifier
                .constrainAs(txChangePercent) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                }
                .bgRounded5ChangeNumber(coin.changePercent.toDouble())

        )

    }
}

