package com.pavlov.products.presentation.mvi

import com.pavlov.ui.view_module.UiEffect

sealed interface ProductDetailsEffect : UiEffect {
    data object NavigateBack : ProductDetailsEffect
    data object NavigateToProfile : ProductDetailsEffect
}

