package com.pavlov.navigationthreetest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.pavlov.navigation.NavigationCoordinator
import com.pavlov.navigation.EntryBuilder
import com.pavlov.navigationthreetest.ui.BottomNavigationBar
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var entryBuilders: Set<@JvmSuppressWildcards EntryBuilder>

    @Inject
    lateinit var navigationCoordinator: NavigationCoordinator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainContent()
        }
    }

    @Composable
    private fun MainContent() {
        // Спостерігаємо за змінами currentKey
        val currentKey by remember {
            derivedStateOf { navigationCoordinator.currentKey }
        }

        val shouldShowBottomBar by remember {
            derivedStateOf { navigationCoordinator.shouldShowBottomBar() }
        }
        val BottomBarHeight = 80.dp

        val bottomInset by animateDpAsState(
            targetValue = if (shouldShowBottomBar) BottomBarHeight else 0.dp,
            label = "bottomInset"
        )

        Scaffold { paddingValues ->
            Box(Modifier.fillMaxSize().padding(paddingValues)) {

                NavDisplay(
                    backStack = navigationCoordinator.backStack,
                    onBack = { navigationCoordinator.goBack() },
                    entryProvider = entryProvider {
                        entryBuilders.forEach { builder ->
                            builder.build(this, navigationCoordinator, PaddingValues(bottom = bottomInset))
                        }
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(bottom = bottomInset),
                    transitionSpec = {
                        slideInHorizontally { it } togetherWith slideOutHorizontally { -it }
                    },
                    popTransitionSpec = {
                        slideInHorizontally { -it } togetherWith slideOutHorizontally { it }
                    },
                    predictivePopTransitionSpec = {
                        slideInHorizontally { -it } togetherWith slideOutHorizontally { it }
                    },
                )

                AnimatedVisibility(
                    visible = shouldShowBottomBar,
                    enter = slideInVertically { it } + fadeIn(),
                    exit = slideOutVertically { it } + fadeOut(),
                    modifier = Modifier.align(Alignment.BottomCenter)
                ) {
                    BottomNavigationBar(
                        currentTab = currentKey,
                        onTabSelected = { tab -> navigationCoordinator.navigate(tab) }
                    )
                }
            }
        }
    }
}