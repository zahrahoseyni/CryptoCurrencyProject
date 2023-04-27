package com.zahrahosseini.cryptocurrencyproject.feature_market.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.zahrahosseini.cryptocurrencyproject.feature_market.domain.entity.CoinList


@Entity(tableName = "market_table")
class MarketEntity(
    var coinList: CoinList
) {

    @PrimaryKey(autoGenerate = false)
    var id: Int = 0

}