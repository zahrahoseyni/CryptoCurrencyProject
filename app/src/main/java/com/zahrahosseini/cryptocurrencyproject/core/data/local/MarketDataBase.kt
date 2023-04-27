package com.zahrahosseini.cryptocurrencyproject.core.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.zahrahosseini.cryptocurrencyproject.feature_market.data.local.MarketDao
import com.zahrahosseini.cryptocurrencyproject.feature_market.data.local.MarketEntity
import com.zahrahosseini.cryptocurrencyproject.feature_market.data.local.MarketTypeConverter


@Database(
    entities = [MarketEntity::class],
    version = 1,
    exportSchema = true
)
@TypeConverters(MarketTypeConverter::class)
abstract class MarketDataBase : RoomDatabase() {

    abstract fun marketDao(): MarketDao

}