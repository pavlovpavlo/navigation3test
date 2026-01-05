package com.pavlov.onboarding.presentation.onboarding2.presentation.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.pavlov.navigation.NavigationCoordinator
import com.pavlov.navigation.Onboarding3Key
import com.pavlov.onboarding.presentation.onboarding2.presentation.Onboarding2Screen
import com.pavlov.onboarding.presentation.onboarding2.presentation.Onboarding2ViewModel
import com.pavlov.onboarding.presentation.onboarding2.presentation.mvi.Onboarding2Effect

@Composable
fun Onboarding2ScreenEntry(
    navigationCoordinator: NavigationCoordinator,
    viewModelProvider: @Composable () -> Onboarding2ViewModel,
    paddingValues: PaddingValues
) {
    val viewModel = viewModelProvider()
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.uiEffect.collect { effect ->
            when (effect) {
                Onboarding2Effect.NavigateToOnboarding3 -> {
                    navigationCoordinator.navigate(Onboarding3Key)
                }
            }
        }
    }

    Onboarding2Screen(
        state = state,
        onIntent = viewModel::onIntent,
        paddingValues = paddingValues
    )
}

