package com.pavlov.onboarding.presentation.onboarding2.presentation.mvi

import com.pavlov.ui.view_module.UiState

data class Onboarding2State(
    val title: String = "Discover Features",
    val description: String = "This is the second onboarding screen"
) : UiState

