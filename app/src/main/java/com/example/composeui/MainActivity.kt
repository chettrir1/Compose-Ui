package com.example.composeui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.composeui.ui.HomeScreen
import com.example.composeui.ui.ProfileScreen
import com.example.composeui.ui.theme.MeditationUIYouTubeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MeditationUIYouTubeTheme {
                ProfileScreen()
            }
        }
    }
}
