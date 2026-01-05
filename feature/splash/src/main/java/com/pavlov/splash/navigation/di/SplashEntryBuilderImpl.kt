package com.pavlov.splash.navigation.di

import androidx.compose.foundation.layout.PaddingValues
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.pavlov.navigation.EntryBuilder
import com.pavlov.navigation.NavigationCoordinator
import com.pavlov.splash.navigation.featureSplashBuilder
import com.pavlov.splash.presentation.SplashViewModel
import javax.inject.Inject

class SplashEntryBuilderImpl @Inject constructor() : EntryBuilder {
    override fun build(
        scope: EntryProviderScope<NavKey>,
        coordinator: NavigationCoordinator,
        padding: PaddingValues
    ) {
        with(scope) {
            featureSplashBuilder(
                navigationCoordinator = coordinator,
                viewModelProvider = { hiltViewModel<SplashViewModel>() },
                paddingValues = padding
            )
        }
    }
}