package com.pavlov.onboarding.presentation.onboarding3.presentation.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.pavlov.navigation.HomeKey
import com.pavlov.navigation.NavigationCoordinator
import com.pavlov.onboarding.presentation.onboarding3.presentation.Onboarding3Screen
import com.pavlov.onboarding.presentation.onboarding3.presentation.Onboarding3ViewModel
import com.pavlov.onboarding.presentation.onboarding3.presentation.mvi.Onboarding3Effect

@Composable
fun Onboarding3ScreenEntry(
    navigationCoordinator: NavigationCoordinator,
    viewModelProvider: @Composable () -> Onboarding3ViewModel,
    paddingValues: PaddingValues
) {
    val viewModel = viewModelProvider()
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.uiEffect.collect { effect ->
            when (effect) {
                Onboarding3Effect.NavigateToHome -> {
                    navigationCoordinator.navigateAndClearBackStack(HomeKey)
                }
            }
        }
    }

    Onboarding3Screen(
        state = state,
        onIntent = viewModel::onIntent,
        paddingValues = paddingValues
    )
}

