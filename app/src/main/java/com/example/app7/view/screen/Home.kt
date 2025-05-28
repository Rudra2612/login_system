package com.example.app7.view.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import com.example.app7.controller.HomeController
import com.example.app7.model.UserModel

@Composable
fun Home(controller: NavHostController) {

    val content = LocalContext.current
    val homeController by lazy {
        HomeController(content)
    }
    val userlist: ArrayList<UserModel> = homeController.getAllUser()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xC4DCADE8)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(userlist.size) {
            val user = userlist[it]
            Card {
                Text(user.email)
            }
        }
    }
}