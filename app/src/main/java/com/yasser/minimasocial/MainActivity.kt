package com.yasser.minimasocial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.yasser.minimasocial.ui.MSApp
import com.yasser.minimasocial.core.designsystem.theme.MinimaSocialTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val viewModel: MainActivityViewModel by viewModels()
        setContent {
            MinimaSocialTheme {
                MSApp()
            }
        }
    }




}