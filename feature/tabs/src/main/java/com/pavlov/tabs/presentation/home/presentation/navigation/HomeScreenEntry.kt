package com.pavlov.tabs.presentation.home.presentation.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.pavlov.navigation.NavigationCoordinator
import com.pavlov.navigation.ProductDetailsKey
import com.pavlov.tabs.presentation.home.presentation.HomeScreen
import com.pavlov.tabs.presentation.home.presentation.HomeViewModel
import com.pavlov.tabs.presentation.home.presentation.mvi.HomeEffect

@Composable
fun HomeScreenEntry(
    navigationCoordinator: NavigationCoordinator,
    viewModelProvider: @Composable () -> HomeViewModel,
    paddingValues: PaddingValues
) {
    val viewModel = viewModelProvider()
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.uiEffect.collect { effect ->
            when (effect) {
                is HomeEffect.NavigateToProductDetails -> {
                    navigationCoordinator.navigate(ProductDetailsKey(effect.productId))
                }
            }
        }
    }

    HomeScreen(
        state = state,
        onIntent = viewModel::onIntent,
        paddingValues = paddingValues
    )
}

