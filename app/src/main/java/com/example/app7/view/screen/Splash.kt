package com.example.app7.view.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.app7.view.navigation.ScreenRoute
import kotlinx.coroutines.delay

@Composable
fun Splash(controller: NavHostController) {
    LaunchedEffect(true) {
        delay(2000)
        controller.navigate(ScreenRoute.Home.route) {
            popUpTo(ScreenRoute.Splash.route) {
                inclusive =true
            }
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray),
        contentAlignment = Alignment.Center
    ) {
        Text("Splash Screen", fontSize = 40.sp)
    }
}
