package com.example.app7.view.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.app7.view.navigation.ScreenRoute

@Composable
fun Home(controller: NavHostController) {
    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Color.Blue),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Home Screen", fontSize = 40.sp)
            ElevatedButton(onClick = {
                controller.navigate(
                    ScreenRoute.Second.route
                )
            }) {
                Text("Second page")
            }
        }
    }
}
    /*Scaffold { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            Image(
                painter = painterResource(R.drawable.background_image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                MyButton(R.drawable.play_button) {
                    controller.navigate(
                        ScreenRoute.Second.route
                    )
                }
                MyButton(R.drawable.level_button) { }
                MyButton(R.drawable.buy_pro_button) { }
            }
        }
    }*/
    /*@Composable
    fun MyButton(image: Int, clickable: () -> Unit) {
        Image(
            painter = painterResource(image),
            contentDescription = null,
            modifier = Modifier
                .size(250.dp, 100.dp)
                .padding(0.dp, 8.dp)
                .clickable(onClick = clickable)
        )
    }*/
