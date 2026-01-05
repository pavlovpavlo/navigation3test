package com.pavlov.onboarding.presentation.onboarding1.presentation.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.pavlov.navigation.NavigationCoordinator
import com.pavlov.navigation.Onboarding2Key
import com.pavlov.onboarding.presentation.onboarding1.presentation.Onboarding1Screen
import com.pavlov.onboarding.presentation.onboarding1.presentation.Onboarding1ViewModel
import com.pavlov.onboarding.presentation.onboarding1.presentation.mvi.Onboarding1Effect

@Composable
fun Onboarding1ScreenEntry(
    navigationCoordinator: NavigationCoordinator,
    viewModelProvider: @Composable () -> Onboarding1ViewModel,
    paddingValues: PaddingValues
) {
    val viewModel = viewModelProvider()
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.uiEffect.collect { effect ->
            when (effect) {
                Onboarding1Effect.NavigateToOnboarding2 -> {
                    navigationCoordinator.navigate(Onboarding2Key)
                }
            }
        }
    }

    Onboarding1Screen(
        state = state,
        onIntent = viewModel::onIntent,
        paddingValues = paddingValues
    )
}

