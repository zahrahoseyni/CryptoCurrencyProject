package com.zahrahosseini.cryptocurrencyproject.feature_market.data.remote

import com.zahrahosseini.cryptocurrencyproject.feature_market.domain.entity.CoinListResponse
import retrofit2.Response
import retrofit2.http.GET

interface MarketApi {

    @GET("currency_prices/")
    suspend fun getCoinsList(): Response<List<CoinListResponse>>

}