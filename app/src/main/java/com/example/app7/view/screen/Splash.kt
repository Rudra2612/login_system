package com.example.app7.view.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.app7.R
import com.example.app7.controller.PrefController
import com.example.app7.view.navigation.ScreenRoute
import kotlinx.coroutines.delay

@Composable
fun Splash(controller: NavHostController) {

    val context = LocalContext.current
    LaunchedEffect(true) {
        delay(2000)

        val prefController = PrefController(context)
        val route = if(prefController.isLogin()) ScreenRoute.Home.route else ScreenRoute.Login.route
        controller.navigate(route) {
            popUpTo(ScreenRoute.Splash.route) {
                inclusive =true
            }
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFA699AD)),
        contentAlignment = Alignment.Center
    ) {
        Image(painter = painterResource(R.drawable.logo),
            contentDescription = null,
            modifier = Modifier.size(150.dp))
    }
}
