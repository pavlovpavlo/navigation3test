package com.pavlov.tabs.presentation.products.presentation.mvi

import com.pavlov.ui.view_module.UiEffect

sealed interface ProductsEffect : UiEffect {
    data class NavigateToProductDetails(val productId: String) : ProductsEffect
}

