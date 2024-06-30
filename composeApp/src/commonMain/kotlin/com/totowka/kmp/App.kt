package com.totowka.kmp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.totowka.kmp.ui.theme.AppTheme
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import yandexschool.composeapp.generated.resources.Res
import yandexschool.composeapp.generated.resources.hello_world
import yandexschool.composeapp.generated.resources.icon

@Composable
internal fun App() = AppTheme {
    MaterialTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = stringResource(Res.string.hello_world),
                color = Color.Black,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Image(
                painter = painterResource(Res.drawable.icon),
                modifier = Modifier.size(48.dp),
                contentDescription = null
            )
        }
    }
}
