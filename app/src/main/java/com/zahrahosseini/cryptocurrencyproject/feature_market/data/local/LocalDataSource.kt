package com.zahrahosseini.cryptocurrencyproject.feature_market.data.local

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val marketDao: MarketDao
) {

    suspend fun insert(marketEntity: MarketEntity) {
        marketDao.insert(marketEntity)
    }

    fun read(): Flow<List<MarketEntity>> {
        return marketDao.read()
    }
}