package com.pavlov.splash.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.pavlov.navigation.NavigationCoordinator
import com.pavlov.navigation.SplashKey
import com.pavlov.splash.presentation.SplashViewModel
import com.pavlov.splash.presentation.navigation.ScreenSplashBuilder

fun EntryProviderScope<NavKey>.featureSplashBuilder(
    navigationCoordinator: NavigationCoordinator,
    viewModelProvider: @Composable () -> SplashViewModel,
    paddingValues: PaddingValues
) {
    entry<SplashKey> {
        ScreenSplashBuilder(navigationCoordinator, viewModelProvider, paddingValues)
    }
}