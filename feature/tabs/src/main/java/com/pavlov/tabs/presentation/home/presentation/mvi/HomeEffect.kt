package com.pavlov.tabs.presentation.home.presentation.mvi

import com.pavlov.ui.view_module.UiEffect

sealed interface HomeEffect : UiEffect {
    data class NavigateToProductDetails(val productId: String) : HomeEffect
}

