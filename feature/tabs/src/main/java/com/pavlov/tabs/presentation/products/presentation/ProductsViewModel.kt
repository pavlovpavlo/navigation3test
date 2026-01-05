package com.pavlov.tabs.presentation.products.presentation

import com.pavlov.tabs.presentation.products.presentation.mvi.ProductsEffect
import com.pavlov.tabs.presentation.products.presentation.mvi.ProductsIntent
import com.pavlov.tabs.presentation.products.presentation.mvi.ProductsState
import com.pavlov.ui.view_module.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor() : BaseViewModel<ProductsState, ProductsEffect>(ProductsState()) {

    fun onIntent(intent: ProductsIntent) {
        when (intent) {
            is ProductsIntent.OnProductClicked -> {
                publishEffect(ProductsEffect.NavigateToProductDetails(intent.productId))
            }
        }
    }
}

