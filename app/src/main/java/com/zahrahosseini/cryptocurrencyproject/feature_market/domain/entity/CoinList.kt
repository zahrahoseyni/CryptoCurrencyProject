package com.zahrahosseini.cryptocurrencyproject.feature_market.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CoinList(
    val results: List<CoinListItem>
) : Parcelable