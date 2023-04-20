package com.zahrahosseini.cryptocurrencyproject.feature_market.di


import com.zahrahosseini.cryptocurrencyproject.feature_market.data.remote.MarketApi
import com.zahrahosseini.cryptocurrencyproject.feature_market.data.repository.MarketRepository
import com.zahrahosseini.cryptocurrencyproject.feature_market.data.repository.MarketRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MarketModule {

    @Singleton
    @Provides
    fun providesMoviesRepository(marketApi: MarketApi): MarketRepository =
        MarketRepositoryImpl(marketApi)

    @Singleton
    @Provides
    fun provideMovieApi(retrofit: Retrofit): MarketApi =
        retrofit.create(MarketApi::class.java)
}