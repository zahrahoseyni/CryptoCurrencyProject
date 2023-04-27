package com.zahrahosseini.cryptocurrencyproject.feature_market.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface MarketDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(marketEntity: MarketEntity)

    @Query("SELECT * FROM market_table ORDER BY id ASC")
    fun read(): Flow<List<MarketEntity>>

}