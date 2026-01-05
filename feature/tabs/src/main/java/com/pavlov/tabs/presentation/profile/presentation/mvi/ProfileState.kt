package com.pavlov.tabs.presentation.profile.presentation.mvi

import com.pavlov.ui.view_module.UiState

data class ProfileState(
    val title: String = "Profile",
    val userName: String = "John Doe",
    val email: String = "john.doe@example.com"
) : UiState

