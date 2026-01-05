package com.pavlov.onboarding.presentation.onboarding3.presentation.mvi

import com.pavlov.ui.view_module.UiState

data class Onboarding3State(
    val title: String = "Get Started",
    val description: String = "You're ready to explore the app!"
) : UiState

