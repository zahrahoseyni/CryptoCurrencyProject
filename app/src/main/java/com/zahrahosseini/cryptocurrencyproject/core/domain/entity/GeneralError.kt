package com.zahrahosseini.cryptocurrencyproject.core.domain.entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize
data class GeneralError(
    @SerializedName("status_message")
    val status: String,
    @SerializedName("status_code")
    val code: String,
    val success: Boolean,
) : Parcelable

