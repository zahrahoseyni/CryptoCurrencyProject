package com.zahrahosseini.cryptocurrencyproject.core.utils

import android.accounts.NetworkErrorException
import android.content.Context
import android.widget.Toast
import java.net.ConnectException
import java.net.UnknownHostException
import java.text.DecimalFormat
import kotlin.math.abs

fun Double.handleDecimal(): String {
    //To handle negative numbers we should check absolute of the number
    val abs= abs(this)
    return if (abs <= 0.000000000001) {
        DecimalFormat("0.###############").format(this)
    }else if (abs <= 0.000000001) {
        DecimalFormat("0.#############").format(this)
    }else if (abs <= 0.000001) {
        DecimalFormat("0.##########").format(this)
    }  else if (abs <= 0.001) {
        DecimalFormat("0.#######").format(this)
    }  else  if (abs < 1) {
        DecimalFormat("0.####").format(this)
    }  else if (abs >= 1) {
        DecimalFormat("###,###,###,###.##").format(this)
    } else {
        this.toString()
//        DecimalFormat("0.###").format(this)
    }
}


fun Context.showToast(message: String?) {
    message?.let {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}

fun Context.handleExceptions(exception: Exception) {
    val message = when (exception) {
        is NetworkErrorException,
        is ConnectException,
        is UnknownHostException -> "An error occurred while connecting to the network"
        else -> {
            exception.message
        }
    }
    this.showToast(message)
}