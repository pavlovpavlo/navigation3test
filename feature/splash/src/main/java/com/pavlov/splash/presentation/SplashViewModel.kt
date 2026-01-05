package com.pavlov.splash.presentation

import androidx.lifecycle.ViewModel
import com.pavlov.splash.presentation.mvi.SplashEffect
import com.pavlov.splash.presentation.mvi.SplashIntent
import com.pavlov.splash.presentation.mvi.SplashState
import com.pavlov.ui.view_module.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(

): BaseViewModel<SplashState, SplashEffect>(SplashState()) {

    init {
        viewModelScope.launch {
            delay(2000L)
            publishEffect(SplashEffect.NavigateToOnboarding)
        }
    }

    fun onIntent(intent: SplashIntent) {

    }
}