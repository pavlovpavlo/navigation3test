package com.pavlov.onboarding.presentation.onboarding1.presentation.mvi

import com.pavlov.ui.view_module.UiEffect

sealed interface Onboarding1Effect : UiEffect {
    data object NavigateToOnboarding2 : Onboarding1Effect
}

