package com.zahrahosseini.cryptocurrencyproject.feature_market.presentation.compose_view.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
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
import com.zahrahosseini.cryptocurrencyproject.feature_market.presentation.compose_view.MarketItemList
import com.zahrahosseini.cryptocurrencyproject.feature_market.presentation.compose_view.SearchBox
import com.zahrahosseini.cryptocurrencyproject.feature_market.presentation.compose_view.shimmer.ShimmerAnimation
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MarketScreen(viewModel: MarketViewModel) {

    val searchText = remember { mutableStateOf("") }
    val marketCoinsList = viewModel.coinListResponses

    val refreshScope = rememberCoroutineScope()
    val refreshing = viewModel.isRefreshing.collectAsState()
    val loading = viewModel.isLoading.collectAsState()

    fun refresh() = refreshScope.launch {
        viewModel._isRefreshing.value = true
        viewModel.getMarketCoinsList()
    }

    val state = rememberPullRefreshState(refreshing.value, ::refresh)


    ConstraintLayout(modifier = Modifier.padding(bottom = 30.dp)) {
        val (txtHeader, cmpList, searchBox) = createRefs()

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


        SearchBox(
            Modifier.constrainAs(searchBox) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                top.linkTo(txtHeader.bottom, 12.dp)
            },
            text = searchText
        )


        Box(
            Modifier
                .pullRefresh(state)
                .constrainAs(cmpList) {
                    top.linkTo(searchBox.bottom, 16.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }) {
            LazyColumn(
                modifier = Modifier.padding(
                    bottom = 50.dp,
                    start = 16.dp,
                    end = 16.dp,
                    top = 16.dp
                ),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {

                if (loading.value) {

                    repeat(10) {
                        item {
                            ShimmerAnimation()

                        }
                    }
                } else {
                    if (searchText.value == "") {
                        marketCoinsList
                    } else {
                        marketCoinsList.filter {
                            it.name.lowercase().contains(searchText.value.lowercase()) ||
                                    it.symbol.lowercase().contains(searchText.value.lowercase()) ||
                                    it.nameFa.lowercase().contains(searchText.value.lowercase())

                        }
                    }.forEach { item ->

                        item {
                            MarketItemList(coin = item)
                        }
                    }
                }

                item {
                    Spacer(modifier = Modifier.size(32.dp))
                }

            }

            PullRefreshIndicator(refreshing.value, state, Modifier.align(Alignment.TopCenter))
        }
    }
}
