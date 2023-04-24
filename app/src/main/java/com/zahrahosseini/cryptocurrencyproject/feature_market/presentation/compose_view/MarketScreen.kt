package com.zahrahosseini.cryptocurrencyproject.feature_market.presentation.compose_view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.zahrahosseini.cryptocurrencyproject.R
import com.zahrahosseini.cryptocurrencyproject.feature_market.presentation.MarketViewModel

@Composable
fun MarketScreen(viewModel: MarketViewModel) {

    val marketCoinsList = viewModel.marketCoinsResult.collectAsState()


    ConstraintLayout(modifier = Modifier.padding(bottom = 30.dp)) {
        val (txtHeader, cmpList) = createRefs()

        val topGuideline = createGuidelineFromTop(16.dp)
        val startGuideline = createGuidelineFromStart(8.dp)

        Text(
            modifier = Modifier.constrainAs(txtHeader) {
                top.linkTo(topGuideline)
                start.linkTo(startGuideline)
            },
            text = stringResource(id = R.string.txt_header),
            color = Color.Black,
            style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold)
        )

        LazyColumn(
            modifier = Modifier
                .constrainAs(cmpList) {
                    top.linkTo(txtHeader.bottom, 16.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .padding(bottom = 50.dp, start = 16.dp, end = 16.dp, top = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {

            marketCoinsList.value.forEach { coin ->
                item {
                    MarketItemList(coin)
                }
            }

        }
    }

}