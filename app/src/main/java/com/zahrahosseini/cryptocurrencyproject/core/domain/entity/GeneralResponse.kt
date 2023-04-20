package com.zahrahosseini.cryptocurrencyproject.core.domain.entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class GeneralResponse(
    @SerializedName("message")
    val message: String
) : Parcelable