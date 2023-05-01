package com.zahrahosseini.cryptocurrencyproject.feature_market.presentation

import android.content.ContentValues.TAG
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.zahrahosseini.cryptocurrencyproject.core.utils.handleExceptions
import com.zahrahosseini.cryptocurrencyproject.core.utils.showToast
import com.zahrahosseini.cryptocurrencyproject.feature_market.presentation.compose_view.component.MarketScreen
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MarketFragment : Fragment() {

    private val viewModel: MarketViewModel by viewModels()
    private lateinit var mContext: Context

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mContext = requireContext()

        lifecycleScope.launch {
            launch {
                viewModel.errorMessage.collect {
                    mContext.showToast(it)
                }
            }
            launch {
                viewModel.errorException.collectLatest {
                    mContext.handleExceptions(it)
                }
            }

        }

        readCachedData()

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        viewModel.getMarketCoinsList()

        return ComposeView(requireContext()).apply {
            setContent {
                MarketScreen(viewModel = viewModel)
            }
        }
    }

    private fun readCachedData() {
        lifecycleScope.launch {
            viewModel.readMarket.observe(viewLifecycleOwner) { dataBase ->
                if (dataBase.isNotEmpty()) {
                    Log.d("readCachedData:() ", dataBase[0].coinList.results.size.toString())
                    viewModel.coinListResponses.clear()
                    viewModel.coinListResponses.addAll( dataBase[0].coinList.results.subList(0,5))

                } else {
                     viewModel.getMarketCoinsList()
                }
            }
        }
    }
}