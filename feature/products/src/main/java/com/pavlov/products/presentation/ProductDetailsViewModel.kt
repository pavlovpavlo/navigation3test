package com.pavlov.products.presentation

import androidx.lifecycle.SavedStateHandle
import com.pavlov.products.presentation.mvi.ProductDetailsEffect
import com.pavlov.products.presentation.mvi.ProductDetailsIntent
import com.pavlov.products.presentation.mvi.ProductDetailsState
import com.pavlov.ui.view_module.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : BaseViewModel<ProductDetailsState, ProductDetailsEffect>(ProductDetailsState()) {

    fun setProductId(productId: String){
        publishState { copy(productId = productId, title = "Details: $productId") }
    }

    fun onIntent(intent: ProductDetailsIntent) {
        when (intent) {
            ProductDetailsIntent.OnBackClicked -> {
                publishEffect(ProductDetailsEffect.NavigateBack)
            }
            ProductDetailsIntent.OnProfileClicked -> {
                publishEffect(ProductDetailsEffect.NavigateToProfile)
            }
        }
    }
}

