package com.example.app7.view.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.app7.controller.HomeController
import com.example.app7.controller.PrefController
import com.example.app7.model.UserModel
import com.example.app7.ui.theme.backColor
import com.example.app7.ui.theme.themeColor
import com.example.app7.ui.theme.themeColorDark
import com.example.app7.view.navigation.ScreenRoute

@Composable
fun Home(controller: NavHostController) {

    val context = LocalContext.current
    val prefController = PrefController(context)
    val homeController by lazy {
        HomeController(context)
    }
    val userlist =
        remember { mutableStateListOf<UserModel>().apply { addAll(homeController.getAllUser()) } }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = backColor)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 10.dp, end = 20.dp)
                .weight(0.5f),
            horizontalArrangement = Arrangement.End
        ) {
            Button(
                onClick = {
                    prefController.removeUser()
                    controller.navigate(ScreenRoute.Login.route) {
                        popUpTo(ScreenRoute.Home.route) {
                            inclusive = true
                        }
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = themeColor,
                    contentColor = Color.White
                )
            ) {
                Text("Log out")
            }
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .weight(6f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(userlist.size) {
                val user = userlist[it]
                Card(
                    modifier = Modifier
                        .padding(5.dp)
                        .size(width = 350.dp, height = 45.dp),
                    border = BorderStroke(1.dp, color = themeColorDark),
                    shape = RoundedCornerShape(10.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0x4BEAA0E5),
                        contentColor = themeColor
                    ),
                    onClick = {
                        homeController.removeUser(user.email)
                        userlist.remove(user)
                    }
                ) {
                    Text(
                        text = user.email,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxSize(),
                        fontSize = 25.sp
                    )
                }
            }
        }
    }
}