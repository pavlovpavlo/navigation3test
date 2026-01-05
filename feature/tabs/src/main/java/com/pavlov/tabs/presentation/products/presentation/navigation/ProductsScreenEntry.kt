package com.pavlov.tabs.presentation.products.presentation.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.pavlov.navigation.NavigationCoordinator
import com.pavlov.navigation.ProductDetailsKey
import com.pavlov.tabs.presentation.products.presentation.ProductsScreen
import com.pavlov.tabs.presentation.products.presentation.ProductsViewModel
import com.pavlov.tabs.presentation.products.presentation.mvi.ProductsEffect

@Composable
fun ProductsScreenEntry(
    navigationCoordinator: NavigationCoordinator,
    viewModelProvider: @Composable () -> ProductsViewModel,
    paddingValues: PaddingValues
) {
    val viewModel = viewModelProvider()
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.uiEffect.collect { effect ->
            when (effect) {
                is ProductsEffect.NavigateToProductDetails -> {
                    navigationCoordinator.navigate(ProductDetailsKey(effect.productId))
                }
            }
        }
    }

    ProductsScreen(
        state = state,
        onIntent = viewModel::onIntent,
        paddingValues = paddingValues
    )
}

