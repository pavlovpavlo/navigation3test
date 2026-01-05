package com.pavlov.tabs.presentation.home.presentation.mvi

import com.pavlov.ui.view_module.UiState

data class HomeState(
    val title: String = "Home",
    val products: List<String> = listOf("Product 1", "Product 2", "Product 3")
) : UiState

