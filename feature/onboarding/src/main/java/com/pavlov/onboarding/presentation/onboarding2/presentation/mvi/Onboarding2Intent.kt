package com.pavlov.onboarding.presentation.onboarding2.presentation.mvi

sealed interface Onboarding2Intent {
    data object OnNextClicked : Onboarding2Intent
}

