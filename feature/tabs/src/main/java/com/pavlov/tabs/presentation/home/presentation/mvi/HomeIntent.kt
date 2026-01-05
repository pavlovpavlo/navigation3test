package com.pavlov.tabs.presentation.home.presentation.mvi

sealed interface HomeIntent {
    data class OnProductClicked(val productId: String) : HomeIntent
}

