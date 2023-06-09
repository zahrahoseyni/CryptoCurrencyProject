package com.zahrahosseini.cryptocurrencyproject.feature_market.data.repository

import com.zahrahosseini.cryptocurrencyproject.feature_market.domain.entity.CoinListItem
import retrofit2.Response

interface MarketRepository {
    suspend fun getCoinsList(): Response<List<CoinListItem>>

}