package com.pavlov.onboarding.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.pavlov.navigation.NavigationCoordinator
import com.pavlov.navigation.Onboarding1Key
import com.pavlov.navigation.Onboarding2Key
import com.pavlov.navigation.Onboarding3Key
import com.pavlov.onboarding.presentation.onboarding1.presentation.Onboarding1ViewModel
import com.pavlov.onboarding.presentation.onboarding1.presentation.navigation.Onboarding1ScreenEntry
import com.pavlov.onboarding.presentation.onboarding2.presentation.Onboarding2ViewModel
import com.pavlov.onboarding.presentation.onboarding2.presentation.navigation.Onboarding2ScreenEntry
import com.pavlov.onboarding.presentation.onboarding3.presentation.Onboarding3ViewModel
import com.pavlov.onboarding.presentation.onboarding3.presentation.navigation.Onboarding3ScreenEntry

fun EntryProviderScope<NavKey>.featureOnboardingBuilder(
    navigationCoordinator: NavigationCoordinator,
    onboarding1ViewModelProvider: @Composable () -> Onboarding1ViewModel,
    onboarding2ViewModelProvider: @Composable () -> Onboarding2ViewModel,
    onboarding3ViewModelProvider: @Composable () -> Onboarding3ViewModel,
    paddingValues: PaddingValues
) {
    entry<Onboarding1Key> {
        Onboarding1ScreenEntry(navigationCoordinator, onboarding1ViewModelProvider, paddingValues)
    }
    entry<Onboarding2Key> {
        Onboarding2ScreenEntry(navigationCoordinator, onboarding2ViewModelProvider, paddingValues)
    }
    entry<Onboarding3Key> {
        Onboarding3ScreenEntry(navigationCoordinator, onboarding3ViewModelProvider, paddingValues)
    }
}
