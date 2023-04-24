package com.zahrahosseini.cryptocurrencyproject.feature_market.presentation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.zahrahosseini.cryptocurrencyproject.feature_market.presentation.compose_view.MarketScreen
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MarketFragment : Fragment() {

    private val viewModel: MarketViewModel by viewModels()
    private lateinit var mContext: Context

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mContext = requireContext()

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
}