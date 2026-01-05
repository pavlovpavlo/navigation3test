package com.pavlov.onboarding.presentation.onboarding3.presentation.mvi

sealed interface Onboarding3Intent {
    data object OnGetStartedClicked : Onboarding3Intent
}

