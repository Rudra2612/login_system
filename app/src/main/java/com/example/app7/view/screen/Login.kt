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
import com.example.app7.controller.PrefController
import com.example.app7.ui.theme.backColor
import com.example.app7.ui.theme.blackColor
import com.example.app7.ui.theme.errorColor
import com.example.app7.ui.theme.fcColor
import com.example.app7.ui.theme.placeHolderColor
import com.example.app7.ui.theme.themeColor
import com.example.app7.ui.theme.themeColorDark
import com.example.app7.ui.theme.themeColorLight
import com.example.app7.view.navigation.ScreenRoute

@Composable
fun Login(controller: NavHostController) {

    val context = LocalContext.current
    val prefController = PrefController(context)

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var emptyEmail by remember { mutableStateOf(false) }
    var emptyPassword by remember { mutableStateOf(false) }
    var userNotFound by remember { mutableStateOf(false) }
    var hide by remember { mutableStateOf(true) }
    val homeController by lazy {
        HomeController(context)
    }
    Column(
        modifier = Modifier
            .background(color = backColor)
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
            color = themeColor,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.2f)
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .weight(1.3f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = email,
                onValueChange = {
                    emptyEmail = false
                    userNotFound = false
                    email = it
                },
                label = { Text("Email Address", fontSize = 20.sp) },
                placeholder = {
                    Text(
                        text = "Enter your email address",
                        fontSize = 15.sp,
                        color = placeHolderColor
                    )
                },
                shape = RoundedCornerShape(10.dp),
                singleLine = true,
                textStyle = TextStyle(fontSize = 20.sp, color = themeColorDark),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedLabelColor = blackColor,
                    focusedBorderColor = blackColor,
                    focusedContainerColor = fcColor,
                    unfocusedBorderColor = themeColorDark,
                    unfocusedLabelColor = themeColorDark
                ),
                supportingText = {
                    if (emptyEmail) Text(
                        "please enter email address",
                        color = errorColor
                    )
                },
                modifier = Modifier.size(width = 340.dp, height = 90.dp)
            )

            Spacer(modifier = Modifier.height(15.dp))

            OutlinedTextField(
                value = password,
                onValueChange = {
                    emptyPassword = false
                    userNotFound = false
                    password = it
                },
                label = { Text(text = "Password", fontSize = 20.sp) },
                placeholder = {
                    Text(
                        text = "Enter your Password",
                        fontSize = 15.sp,
                        color = placeHolderColor
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
                textStyle = TextStyle(fontSize = 20.sp, color = themeColorDark),
                visualTransformation = if (hide) PasswordVisualTransformation('*') else VisualTransformation.None,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedLabelColor = Color.Black,
                    focusedBorderColor = Color.Black,
                    focusedTrailingIconColor = Color.Black,
                    focusedContainerColor = fcColor,
                    unfocusedBorderColor = themeColorDark,
                    unfocusedLabelColor = themeColorDark,
                    unfocusedTrailingIconColor = themeColorDark
                ),
                supportingText = {
                    if (emptyPassword) Text(
                        "please enter password",
                        color = errorColor
                    )
                },
                modifier = Modifier.size(width = 340.dp, height = 90.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                "Forgot password?",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 30.dp)
                    .clickable {
                        controller.navigate(ScreenRoute.ForgotPassword.route)
                    },
                color = themeColor,
                textAlign = TextAlign.End
            )

            Spacer(modifier = Modifier.height(5.dp))

            if(userNotFound) {
                Text(
                    "Invalid Email and password",
                    modifier = Modifier
                        .fillMaxWidth(),
                    color = errorColor,
                    textAlign = TextAlign.Center
                )
            } else { Text("")
            }

            Spacer(modifier = Modifier.height(25.dp))

            Button(
                onClick = {
                    if (email.isEmpty()) {
                        emptyEmail = true
                    }
                    if (password.isEmpty()) {
                        emptyPassword = true
                    }
                    if (email.isNotEmpty() && password.isNotEmpty()) {
                        val isUserExist = homeController.isUserExist(email, password)
                        if (isUserExist) {
                            prefController.setUser(email)
                            controller.navigate(ScreenRoute.Home.route) {
                                popUpTo(ScreenRoute.Login.route) {
                                    inclusive = true
                                }
                            }
                        } else {
                            userNotFound = true
                        }
                    }

                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(horizontal = 40.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = themeColor,
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
                color = themeColorLight,
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

            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f),
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.Center
            ) {
                Text("Don't have an account? ", color = themeColorLight)
                Text(
                    "Create Account",
                    color = themeColorDark,
                    modifier = Modifier.clickable {
                        controller.navigate(ScreenRoute.Register.route)
                    })
            }
        }
    }
}