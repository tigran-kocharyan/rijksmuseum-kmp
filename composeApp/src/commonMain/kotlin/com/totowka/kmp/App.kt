package com.totowka.kmp

import androidx.compose.material3.*
import androidx.compose.runtime.*
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import com.totowka.kmp.ui.screens.list.ListScreen
import com.totowka.kmp.ui.theme.AppTheme

@Composable
internal fun App() = AppTheme {
    MaterialTheme {
        Navigator(ListScreen) { navigator ->
            SlideTransition(navigator)
        }
    }
}
