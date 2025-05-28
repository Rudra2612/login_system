package com.example.app7

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.app7.ui.theme.App7Theme
import com.example.app7.view.navigation.NavigationStack

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            App7Theme {
                Scaffold { inerpadding ->
                    Box(modifier = Modifier.padding(inerpadding)) {
                        NavigationStack()
                    }
                }
            }
        }
    }
}