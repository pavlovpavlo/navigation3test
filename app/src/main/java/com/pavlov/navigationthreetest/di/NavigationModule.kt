package com.pavlov.navigationthreetest.di

import com.pavlov.navigation.EntryBuilder
import com.pavlov.onboarding.navigation.di.OnboardingEntryBuilderImpl
import com.pavlov.products.navigation.di.ProductsEntryBuilderImpl
import com.pavlov.splash.navigation.di.SplashEntryBuilderImpl
import com.pavlov.tabs.navigation.di.TabsEntryBuilderImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.multibindings.IntoSet

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class NavigationModule {

    @Binds
    @IntoSet
    abstract fun bindSplashEntryBuilder(
        impl: SplashEntryBuilderImpl
    ): EntryBuilder

    @Binds
    @IntoSet
    abstract fun bindOnboardingEntryBuilder(
        impl: OnboardingEntryBuilderImpl
    ): EntryBuilder

    @Binds
    @IntoSet
    abstract fun bindTabsEntryBuilder(
        impl: TabsEntryBuilderImpl
    ): EntryBuilder

    @Binds
    @IntoSet
    abstract fun bindProductsEntryBuilder(
        impl: ProductsEntryBuilderImpl
    ): EntryBuilder
}