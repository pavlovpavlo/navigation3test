package com.pavlov.splash.presentation.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.pavlov.navigation.HomeKey
import com.pavlov.navigation.NavigationCoordinator
import com.pavlov.navigation.Onboarding1Key
import com.pavlov.splash.presentation.SplashScreen
import com.pavlov.splash.presentation.SplashViewModel
import com.pavlov.splash.presentation.mvi.SplashEffect

@Composable
fun ScreenSplashBuilder(navigationCoordinator: NavigationCoordinator,
                        viewModelProvider: @Composable () -> SplashViewModel,
                        paddingValues: PaddingValues){
    val viewModel = viewModelProvider()
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.uiEffect.collect { effect ->
            when (effect) {
                SplashEffect.NavigateToOnboarding -> {
                    navigationCoordinator.navigate(Onboarding1Key)
                }
                SplashEffect.NavigateToMain -> {
                    navigationCoordinator.navigate(HomeKey)
                }
            }
        }
    }

    SplashScreen(
        state = state,
        onIntent = viewModel::onIntent,
        paddingValues = paddingValues
    )
}