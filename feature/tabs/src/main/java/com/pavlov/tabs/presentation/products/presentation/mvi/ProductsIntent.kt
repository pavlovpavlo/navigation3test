package com.pavlov.tabs.presentation.products.presentation.mvi

sealed interface ProductsIntent {
    data class OnProductClicked(val productId: String) : ProductsIntent
}

