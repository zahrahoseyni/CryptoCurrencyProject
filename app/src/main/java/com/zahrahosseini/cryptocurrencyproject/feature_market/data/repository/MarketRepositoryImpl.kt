package com.zahrahosseini.cryptocurrencyproject.feature_market.data.repository

import com.zahrahosseini.cryptocurrencyproject.feature_market.data.remote.MarketApi
import com.zahrahosseini.cryptocurrencyproject.feature_market.domain.entity.CoinListResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject


class MarketRepositoryImpl @Inject constructor(
    private val marketApi: MarketApi,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : MarketRepository {
    override suspend fun getCoinsList(): Response<CoinListResponse> =
        withContext(ioDispatcher) {
            marketApi.getCoinsList()
        }

}