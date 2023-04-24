package com.zahrahosseini.cryptocurrencyproject.core.utils

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
