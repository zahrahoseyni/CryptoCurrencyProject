package com.zahrahosseini.cryptocurrencyproject.feature_market.domain.entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class CoinListResponse(
    val id: Int,
    val name: String,
    @SerializedName("name_fa")
    val nameFa: String,
    val created: String,
    val symbol: String,
    @SerializedName("price_in_usdt")
    val priceInUsdt: String,
    @SerializedName("change_percent")
    val changePercent: String,
    @SerializedName("usdt_volume")
    val usdtVolume: String,
    @SerializedName("is_swappable")
    val isSwappable: Boolean,
    val volume: String,
    val markets: List<Market>,

    ) : Parcelable

@Parcelize
data class Market(
    val id: Int,
    @SerializedName("first_currency")
    val firstCurrency: Currency,
    @SerializedName("second_currency")
    val secondCurrency: Currency,
    @SerializedName("name_fa")
    val nameFa: String,
    val symbol: String,
    @SerializedName("price_precision")
    val pricePrecision: Int,
    @SerializedName("first_currency_precision")
    val firstCurrencyPrecision: Int,
    val enable: Boolean,
    @SerializedName("last_trade_price")
    val lastTradePrice: String,
    val price: String,
    @SerializedName("change_percent")
    val changePercent: String,
    @SerializedName("usdt_volume")
    val usdtVolume: String,
    val volume: String,
    val high: String,
    val low: String,
) : Parcelable

@Parcelize
data class Currency(
    val id: Int,
    val symbol: String,
    val name: String,
    @SerializedName("name_fa")
    val nameFa: String,
) : Parcelable
