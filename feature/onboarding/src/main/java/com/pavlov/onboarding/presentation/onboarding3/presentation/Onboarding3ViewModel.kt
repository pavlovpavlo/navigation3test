package com.pavlov.onboarding.presentation.onboarding3.presentation

import com.pavlov.onboarding.presentation.onboarding3.presentation.mvi.Onboarding3Effect
import com.pavlov.onboarding.presentation.onboarding3.presentation.mvi.Onboarding3Intent
import com.pavlov.onboarding.presentation.onboarding3.presentation.mvi.Onboarding3State
import com.pavlov.ui.view_module.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class Onboarding3ViewModel @Inject constructor() : BaseViewModel<Onboarding3State, Onboarding3Effect>(Onboarding3State()) {

    fun onIntent(intent: Onboarding3Intent) {
        when (intent) {
            Onboarding3Intent.OnGetStartedClicked -> {
                publishEffect(Onboarding3Effect.NavigateToHome)
            }
        }
    }
}

