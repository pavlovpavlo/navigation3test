package com.pavlov.tabs.presentation.products.presentation.mvi

import com.pavlov.ui.view_module.UiState

data class ProductsState(
    val title: String = "Products",
    val products: List<String> = listOf("Phone", "Laptop", "Tablet", "Watch", "Headphones")
) : UiState

