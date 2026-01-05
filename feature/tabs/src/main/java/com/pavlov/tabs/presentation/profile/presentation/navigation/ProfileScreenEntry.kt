package com.pavlov.tabs.presentation.profile.presentation.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.pavlov.navigation.NavigationCoordinator
import com.pavlov.tabs.presentation.profile.presentation.ProfileScreen
import com.pavlov.tabs.presentation.profile.presentation.ProfileViewModel
import com.pavlov.tabs.presentation.profile.presentation.mvi.ProfileEffect

@Composable
fun ProfileScreenEntry(
    navigationCoordinator: NavigationCoordinator,
    viewModelProvider: @Composable () -> ProfileViewModel,
    paddingValues: PaddingValues
) {
    val viewModel = viewModelProvider()
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.uiEffect.collect { effect ->
            // Handle effects
        }
    }

    ProfileScreen(
        state = state,
        onIntent = viewModel::onIntent,
        paddingValues = paddingValues
    )
}

