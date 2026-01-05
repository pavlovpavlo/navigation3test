package com.pavlov.tabs.presentation.home.presentation

import com.pavlov.tabs.presentation.home.presentation.mvi.HomeEffect
import com.pavlov.tabs.presentation.home.presentation.mvi.HomeIntent
import com.pavlov.tabs.presentation.home.presentation.mvi.HomeState
import com.pavlov.ui.view_module.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : BaseViewModel<HomeState, HomeEffect>(HomeState()) {

    fun onIntent(intent: HomeIntent) {
        when (intent) {
            is HomeIntent.OnProductClicked -> {
                publishEffect(HomeEffect.NavigateToProductDetails(intent.productId))
            }
        }
    }
}

