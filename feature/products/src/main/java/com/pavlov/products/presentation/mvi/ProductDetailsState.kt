package com.pavlov.products.presentation.mvi

import com.pavlov.ui.view_module.UiState

data class ProductDetailsState(
    val productId: String = "",
    val title: String = "Product Details",
    val description: String = "This is a detailed view of the product"
) : UiState

