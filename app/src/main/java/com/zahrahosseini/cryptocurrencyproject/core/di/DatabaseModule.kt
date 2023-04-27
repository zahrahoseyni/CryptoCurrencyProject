package com.zahrahosseini.cryptocurrencyproject.core.di

import android.content.Context
import androidx.room.Room
import com.zahrahosseini.cryptocurrencyproject.core.data.local.MarketDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        MarketDataBase::class.java,
        "market_database"
    ).build()

    @Singleton
    @Provides
    fun provideDao(database: MarketDataBase) = database.marketDao()

}