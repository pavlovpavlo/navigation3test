package com.pavlov.onboarding.presentation.onboarding1.presentation.mvi

import com.pavlov.ui.view_module.UiState

data class Onboarding1State(
    val title: String = "Welcome",
    val description: String = "This is the first onboarding screen"
) : UiState

