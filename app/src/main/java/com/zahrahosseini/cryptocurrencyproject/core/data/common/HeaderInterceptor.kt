package com.zahrahosseini.cryptocurrencyproject.core.data.common


import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class  HeaderInterceptor @Inject constructor(
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val chainBuilder = chain.request().newBuilder()
        chainBuilder.addHeader("content-type", "application/json")

        return chain.proceed(chainBuilder.build())
    }
}