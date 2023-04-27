package com.zahrahosseini.cryptocurrencyproject.feature_market.data.local

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.zahrahosseini.cryptocurrencyproject.feature_market.domain.entity.CoinList

class MarketTypeConverter {

    val gson = Gson()

    @TypeConverter
    fun coinListToString(coinList: CoinList): String {
        return gson.toJson(coinList)
    }

    @TypeConverter

    fun stringToCoinList(coinListString: String): CoinList {
        val objectType = object : TypeToken<CoinList>() {}.type
        return gson.fromJson(coinListString, objectType)
    }

}