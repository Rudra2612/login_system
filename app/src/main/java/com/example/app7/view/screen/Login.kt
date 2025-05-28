package com.example.app7.view.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.app7.R
import com.example.app7.controller.HomeController
import com.example.app7.view.navigation.ScreenRoute

@Composable
fun Login(controller: NavHostController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var hide by remember { mutableStateOf(true) }
    val content = LocalContext.current
    val homeController by lazy {
        HomeController(content)
    }
    Scaffold { innerpadding ->
        Column(
            modifier = Modifier
                .padding(innerpadding)
                .background(color = Color(0xFFF4DBFF))
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(0.5f),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.logo),
                    contentDescription = null,
                    modifier = Modifier.size(150.dp)
                )
            }

            Text(
                text = "Sign in to your account",
                fontSize = 28.sp,
                color = Color(0xCE9602D2),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.2f)
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                OutlinedTextField(
                    value = email,
                    onValueChange = {
                        email = it
                    },
                    label = { Text("Email Address", fontSize = 20.sp) },
                    placeholder = {
                        Text(
                            text = "Enter your email address",
                            fontSize = 15.sp,
                            color = Color(color = 0x49423B44)
                        )
                    },
                    shape = RoundedCornerShape(10.dp),
                    singleLine = true,
                    textStyle = TextStyle(fontSize = 20.sp, color = Color(0xF76E3B80)),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedLabelColor = Color.Black,
                        focusedBorderColor = Color.Black,
                        focusedContainerColor = Color(0x089602D2),
                        unfocusedBorderColor = Color(0xFF70109D),
                        unfocusedLabelColor = Color(0xE1670F8F)
                    ),
                    modifier = Modifier.size(width = 340.dp, height = 70.dp)
                )

                Spacer(modifier = Modifier.height(15.dp))

                OutlinedTextField(
                    value = password,
                    onValueChange = {
                        password = it
                    },
                    label = { Text(text = "Password", fontSize = 20.sp) },
                    placeholder = {
                        Text(
                            text = "Enter your Password",
                            fontSize = 15.sp,
                            color = Color(color = 0x49423B44)
                        )
                    },
                    trailingIcon = {
                        IconButton(onClick = { hide = !hide }) {
                            Icon(
                                painter = if (hide) painterResource(R.drawable.hide)
                                else painterResource(R.drawable.view),
                                contentDescription = null,
                            )
                        }
                    },
                    shape = RoundedCornerShape(10.dp),
                    singleLine = true,
                    textStyle = TextStyle(fontSize = 20.sp, color = Color(0xF76E3B80)),
                    visualTransformation = if (hide) PasswordVisualTransformation('*') else VisualTransformation.None,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedLabelColor = Color.Black,
                        focusedBorderColor = Color.Black,
                        focusedTrailingIconColor = Color.Black,
                        focusedContainerColor = Color(0x089602D2),
                        unfocusedBorderColor = Color(0xFF70109D),
                        unfocusedLabelColor = Color(0xE1670F8F),
                        unfocusedTrailingIconColor = Color(0xFF70109D)
                    ),
                    modifier = Modifier.size(width = 340.dp, height = 70.dp)
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    "Forgot password?",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 30.dp),
                    color = Color(0x9F9602D2),
                    textAlign = TextAlign.End
                )

                Spacer(modifier = Modifier.height(25.dp))

                Button(
                    onClick = {
                        val isUserExist = homeController.isUserExist(email,password)
                        if(isUserExist) {
                            controller.navigate(ScreenRoute.Home.route) {
                                popUpTo(ScreenRoute.Login.route) {
                                    inclusive = true
                                }
                            }
                        } else {
                            password = ""
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .padding(horizontal = 40.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xE475059F),
                        contentColor = Color.White
                    )
                ) {
                    Text(text = "Sign in", fontSize = 20.sp)
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f),
                verticalArrangement = Arrangement.Top
            ) {
                Text(
                    text = "other way to sign in",
                    color = Color(0x529602D2),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.2f)
                )
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(0.7f),
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.Center
                ) {
                    IconButton(onClick = {}) {
                        Image(
                            painter = painterResource(R.drawable.search),
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize()
                        )
                    }

                    Spacer(modifier = Modifier.width(10.dp))

                    IconButton(onClick = {}) {
                        Image(
                            painter = painterResource(R.drawable.facebook),
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }

                Row(modifier = Modifier
                    .fillMaxSize()
                    .weight(1f),
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.Center) {
                    Text("Don't have an account? ", color = Color(0x529602D2))
                    Text("Create Account",
                        color = Color(0xE475059F),
                        modifier = Modifier.clickable{
                            controller.navigate(ScreenRoute.Register.route)
                        })
                }
            }
        }
    }
}