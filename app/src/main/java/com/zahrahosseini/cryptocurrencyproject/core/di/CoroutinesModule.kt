package com.zahrahosseini.cryptocurrencyproject.core.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import com.zahrahosseini.cryptocurrencyproject.core.di.qualifiers.DefaultDispatcher
import com.zahrahosseini.cryptocurrencyproject.core.di.qualifiers.IoDispatcher
import com.zahrahosseini.cryptocurrencyproject.core.di.qualifiers.MainDispatcher
import com.zahrahosseini.cryptocurrencyproject.core.di.qualifiers.MainImmediateDispatcher

@InstallIn(SingletonComponent::class)
@Module
object CoroutinesModule {

    @Provides
    @DefaultDispatcher
    fun providesDefaultDispatcher(): CoroutineDispatcher = Dispatchers.Default

    @Provides
    @IoDispatcher
    fun providesIoDispatcher(): CoroutineDispatcher = Dispatchers.IO

    @Provides
    @MainDispatcher
    fun providesMainDispatcher(): CoroutineDispatcher = Dispatchers.Main

    @Provides
    @MainImmediateDispatcher
    fun providesMainImmediateDispatcher(): CoroutineDispatcher = Dispatchers.Main.immediate
}
