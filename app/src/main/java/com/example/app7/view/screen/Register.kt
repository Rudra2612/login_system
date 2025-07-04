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
fun Register(controller: NavHostController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var emptyEmail by remember { mutableStateOf(false) }
    var emptyPassword by remember { mutableStateOf(false) }
    var emptyConfirmPassword by remember { mutableStateOf(false) }
    var emailFormatImproper by remember { mutableStateOf(false) }
    var passwordFormatImproper by remember { mutableStateOf(false) }
    var misMatchP by remember { mutableStateOf(false) }
    var userExist by remember { mutableStateOf(false) }
    var hideP by remember { mutableStateOf(true) }
    var hideCP by remember { mutableStateOf(true) }
    val context = LocalContext.current
    val homeController by lazy {
        HomeController(context)
    }
    Column(modifier = Modifier.background(color = backColor)) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(0.5f), contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(R.drawable.logo),
                contentDescription = null,
                modifier = Modifier.size(150.dp)
            )
        }

        Text(
            text = "Create new account",
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
                .weight(2f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = email,
                onValueChange = {
                    emptyEmail = false
                    emailFormatImproper = false
                    userExist = false
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
                    if (emptyEmail) {
                        Text(text = "Please enter email", color = errorColor)
                    } else if (emailFormatImproper) {
                        Text(
                            text = "Please enter email address in proper format",
                            color = errorColor
                        )
                    }
                },
                modifier = Modifier.size(width = 340.dp, height = 90.dp)
            )

            Spacer(modifier = Modifier.height(15.dp))

            OutlinedTextField(
                value = password,
                onValueChange = {
                    emptyPassword = false
                    passwordFormatImproper = false
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
                    IconButton(onClick = { hideP = !hideP }) {
                        Icon(
                            painter = if (hideP) painterResource(R.drawable.hide)
                            else painterResource(R.drawable.view),
                            contentDescription = null,
                        )
                    }
                },
                shape = RoundedCornerShape(10.dp),
                singleLine = true,
                textStyle = TextStyle(fontSize = 20.sp, color = themeColorDark),
                visualTransformation = if (hideP) PasswordVisualTransformation('*') else VisualTransformation.None,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedLabelColor = blackColor,
                    focusedBorderColor = blackColor,
                    focusedTrailingIconColor = blackColor,
                    focusedContainerColor = fcColor,
                    unfocusedBorderColor = themeColorDark,
                    unfocusedLabelColor = themeColorDark,
                    unfocusedTrailingIconColor = themeColorDark
                ),
                supportingText = {
                    if (emptyPassword) {
                        Text(text = "Please enter password", color = errorColor)
                    } else if (passwordFormatImproper) {
                        Text(text = "Password must be more than 8 characters", color = errorColor)
                    }
                },
                modifier = Modifier.size(width = 340.dp, height = 90.dp)
            )

            Spacer(modifier = Modifier.height(15.dp))

            OutlinedTextField(
                value = confirmPassword,
                onValueChange = {
                    emptyConfirmPassword = false
                    misMatchP = false
                    confirmPassword = it
                },
                label = { Text(text = "Confirm Password", fontSize = 20.sp) },
                placeholder = {
                    Text(
                        text = "Enter your confirm Password",
                        fontSize = 15.sp,
                        color = placeHolderColor
                    )
                },
                trailingIcon = {
                    IconButton(onClick = { hideCP = !hideCP }) {
                        Icon(
                            painter = if (hideCP) painterResource(R.drawable.hide)
                            else painterResource(R.drawable.view),
                            contentDescription = null,
                        )
                    }
                },
                shape = RoundedCornerShape(10.dp),
                singleLine = true,
                textStyle = TextStyle(fontSize = 20.sp, color = themeColorDark),
                visualTransformation = if (hideCP) PasswordVisualTransformation('*') else VisualTransformation.None,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedLabelColor = blackColor,
                    focusedBorderColor = blackColor,
                    focusedTrailingIconColor = blackColor,
                    focusedContainerColor = fcColor,
                    unfocusedBorderColor = themeColorDark,
                    unfocusedLabelColor = themeColorDark,
                    unfocusedTrailingIconColor = themeColorDark
                ),
                supportingText = {
                    if (emptyConfirmPassword) Text(
                        "Please re-enter password", color = errorColor
                    )
                },
                modifier = Modifier.size(width = 340.dp, height = 90.dp)
            )

            if (misMatchP) {
                Text(text = "confirm password is mismatch to password", color = errorColor)
            } else if(userExist) {
                Text(text = "This email address already used", color = errorColor)
            } else{
                Text(text = "")
            }

            Spacer(modifier = Modifier.height(15.dp))

            Row {
                Text(
                    text = "i've read and agreed to ",
                    color = themeColor,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "User Agreement",
                    color = themeColorDark,
                )
            }

            Spacer(modifier = Modifier.height(25.dp))

            Button(
                onClick = {
                    if (email.isEmpty()) {
                        emptyEmail = true
                    } else if (!(email.contains('@') && email.contains('.'))) {
                        emailFormatImproper = true
                    }
                    if (password.isEmpty()) {
                        emptyPassword = true
                    } else if (password.length < 8) {
                        passwordFormatImproper = true
                    }
                    if (confirmPassword.isEmpty()) {
                        emptyConfirmPassword = true
                    }
                    if (email.isNotEmpty() && password.isNotEmpty() && confirmPassword.isNotEmpty() && !emailFormatImproper && !passwordFormatImproper) {
                        if (password == confirmPassword) {
                            val isUserExist1 = homeController.isUserExist1(email)
                            if(!isUserExist1) {
                                homeController.addUser(email, password)
                                controller.navigate(ScreenRoute.Login.route) {
                                    popUpTo(ScreenRoute.Register.route) {
                                        inclusive = true
                                    }
                                }
                            } else {
                                userExist = true
                            }
                        } else {
                            misMatchP = true
                        }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(horizontal = 40.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = themeColor, contentColor = Color.White
                )
            ) {
                Text(text = "Sign up", fontSize = 20.sp)
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f), verticalArrangement = Arrangement.Top
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
                Text("Already have an account? ", color = themeColorLight)
                Text(
                    "Sign in", color = themeColorDark, modifier = Modifier.clickable {
                        controller.navigate(ScreenRoute.Login.route) {
                            popUpTo(ScreenRoute.Register.route) {
                                inclusive = true
                            }
                        }
                    })
            }
        }
    }
}