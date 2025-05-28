package com.example.app7.view.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.app7.view.screen.ForgotPassword
import com.example.app7.view.screen.Home
import com.example.app7.view.screen.Login
import com.example.app7.view.screen.Register
import com.example.app7.view.screen.Splash

@Composable
fun NavigationStack() {
    val controller = rememberNavController()
    NavHost(controller, ScreenRoute.Splash.route) {
        composable(route = ScreenRoute.Splash.route) {
            Splash(controller)
        }
        composable(route = ScreenRoute.Home.route) {
            Home(controller)
        }
        composable(route = ScreenRoute.Login.route) {
            Login(controller)
        }
        composable(route = ScreenRoute.Register.route) {
            Register(controller)
        }
        composable(route = ScreenRoute.ForgotPassword.route) {
            ForgotPassword(controller)
        }
    }
}


sealed class ScreenRoute(val route: String) {
    data object Splash : ScreenRoute("splash")
    data object Home : ScreenRoute("home")
    data object Login : ScreenRoute("login")
    data object Register : ScreenRoute("register")
    data object ForgotPassword : ScreenRoute("forgotPassword")
}