package com.zahrahosseini.cryptocurrencyproject.feature_market.presentation

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zahrahosseini.cryptocurrencyproject.core.utils.network.ApiResult
import com.zahrahosseini.cryptocurrencyproject.feature_market.domain.entity.CoinListResponse
import com.zahrahosseini.cryptocurrencyproject.feature_market.domain.usecase.MarketCoinListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MarketViewModel @Inject constructor(
    private val marketCoinListUseCase: MarketCoinListUseCase
) : ViewModel() {

    private val _marketCoinsResult = MutableStateFlow<List<CoinListResponse>>(emptyList())
    val marketCoinsResult: StateFlow<List<CoinListResponse>>
        get() = _marketCoinsResult

    val coinListResponses =
        mutableStateListOf<CoinListResponse>()

    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean>
        get() = _loading

    private val _errorMessage = MutableSharedFlow<String>()
    val errorMessage: SharedFlow<String>
        get() = _errorMessage

    private val _errorException = MutableSharedFlow<Exception>()
    val errorException: SharedFlow<Exception>
        get() = _errorException

    fun getMarketCoinsList() {
        viewModelScope.launch {
            marketCoinListUseCase(Unit).run {
                _loading.value = false
                when (this) {
                    is ApiResult.Error -> {
                        _errorException.emit(this.exception)
                    }
                    is ApiResult.ServerError -> {
                        this.errorBody?.status?.let { _errorMessage.emit(it) }
                    }
                    is ApiResult.Success -> {
                        coinListResponses.addAll(this.data)
                    }
                    else -> {}
                }
            }
        }
    }

}