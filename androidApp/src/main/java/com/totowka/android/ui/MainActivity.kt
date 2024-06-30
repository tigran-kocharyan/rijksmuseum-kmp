package com.totowka.android.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.totowka.android.ui.theme.YandexSchoolTheme
import com.totowka.kmp.domain.CommonInteractor
import org.koin.java.KoinJavaComponent.inject

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val commonInteractor: CommonInteractor by inject(CommonInteractor::class.java)

        setContent {
            YandexSchoolTheme {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White),
                    contentAlignment = Alignment.Center,
                ) {
                    Text(text = commonInteractor.getMessage().message)
                }
            }
        }
    }
}