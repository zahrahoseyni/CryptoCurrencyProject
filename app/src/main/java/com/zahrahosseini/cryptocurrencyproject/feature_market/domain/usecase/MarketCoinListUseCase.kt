package com.zahrahosseini.cryptocurrencyproject.feature_market.domain.usecase


import com.zahrahosseini.cryptocurrencyproject.core.di.qualifiers.IoDispatcher
import com.zahrahosseini.cryptocurrencyproject.core.domain.usecase.ApiUseCase
import com.zahrahosseini.cryptocurrencyproject.feature_market.data.repository.MarketRepository
import com.zahrahosseini.cryptocurrencyproject.feature_market.domain.entity.CoinListResponse
import kotlinx.coroutines.CoroutineDispatcher
import retrofit2.Response
import javax.inject.Inject


class MarketCoinListUseCase @Inject constructor(
    private val marketRepository: MarketRepository,
    @IoDispatcher ioDispatcher: CoroutineDispatcher
) : ApiUseCase<Unit, List<CoinListResponse>>(ioDispatcher) {

    override suspend fun execute(parameters: Unit): Response<List<CoinListResponse>> =
        marketRepository.getCoinsList()
}