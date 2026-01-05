package com.pavlov.onboarding.navigation.di

import androidx.compose.foundation.layout.PaddingValues
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.pavlov.navigation.EntryBuilder
import com.pavlov.navigation.NavigationCoordinator
import com.pavlov.onboarding.navigation.featureOnboardingBuilder
import com.pavlov.onboarding.presentation.onboarding1.presentation.Onboarding1ViewModel
import com.pavlov.onboarding.presentation.onboarding2.presentation.Onboarding2ViewModel
import com.pavlov.onboarding.presentation.onboarding3.presentation.Onboarding3ViewModel
import javax.inject.Inject

class OnboardingEntryBuilderImpl @Inject constructor() : EntryBuilder {
    override fun build(
        scope: EntryProviderScope<NavKey>,
        coordinator: NavigationCoordinator,
        padding: PaddingValues
    ) {
        with(scope) {
            featureOnboardingBuilder(
                navigationCoordinator = coordinator,
                onboarding1ViewModelProvider = { hiltViewModel<Onboarding1ViewModel>() },
                onboarding2ViewModelProvider = { hiltViewModel<Onboarding2ViewModel>() },
                onboarding3ViewModelProvider = { hiltViewModel<Onboarding3ViewModel>() },
                paddingValues = padding
            )
        }
    }
}

