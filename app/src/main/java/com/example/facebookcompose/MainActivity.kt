package com.example.facebookcompose

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.graphics.Color.Companion.Transparent

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.facebookcompose.ui.theme.FacebookComposeTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

//import com.example.facebookcompose.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FacebookComposeTheme {
                TransparentSystemBars()

                val navController = rememberNavController()
                NavHost(navController, startDestination = "home"){
                    composable("home"){
                        HomeScreen()
                    }
                }
            }
        }
    }

    @Composable
    fun TransparentSystemBars(){

        // Remember a SystemUiController
        val systemUiController = rememberSystemUiController()
        val useDarkIcons = !isSystemInDarkTheme()

        DisposableEffect(systemUiController, useDarkIcons) {

            systemUiController.setSystemBarsColor(
                color = Transparent,
                darkIcons = useDarkIcons
            )

            // setStatusBarColor() and setNavigationBarColor() also exist

            onDispose {}
        }
    }
}

