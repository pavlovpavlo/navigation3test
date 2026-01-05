package com.pavlov.products.presentation.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.pavlov.navigation.NavigationCoordinator
import com.pavlov.navigation.ProfileKey
import com.pavlov.products.presentation.ProductDetailsScreen
import com.pavlov.products.presentation.ProductDetailsViewModel
import com.pavlov.products.presentation.mvi.ProductDetailsEffect

@Composable
fun ProductDetailsScreenEntry(
    navigationCoordinator: NavigationCoordinator,
    viewModelProvider: @Composable () -> ProductDetailsViewModel,
    paddingValues: PaddingValues
) {
    val viewModel = viewModelProvider()
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.uiEffect.collect { effect ->
            when (effect) {
                ProductDetailsEffect.NavigateBack -> {
                    navigationCoordinator.goBack()
                }
                ProductDetailsEffect.NavigateToProfile -> {
                    navigationCoordinator.navigate(ProfileKey)
                }
            }
        }
    }

    ProductDetailsScreen(
        state = state,
        onIntent = viewModel::onIntent,
        paddingValues = paddingValues
    )
}

