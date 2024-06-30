package com.totowka.kmp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.totowka.kmp.ui.theme.AppTheme
import org.jetbrains.compose.resources.stringResource
import yandexschool.composeapp.generated.resources.Res
import yandexschool.composeapp.generated.resources.hello_world

@Composable
internal fun App() = AppTheme {
    MaterialTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            contentAlignment = Alignment.Center,
        ) {
            Text(text = stringResource(Res.string.hello_world))
        }
    }
}
