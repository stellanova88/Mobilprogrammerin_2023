package com.example.playingwithnavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.playingwithnavigation.ui.theme.HomeScreen
import com.example.playingwithnavigation.ui.theme.LoginScreen
import com.example.playingwithnavigation.ui.theme.PlayingWithNavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlayingWithNavigationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavigationApp()
                }
            }
        }
    }
}

enum class Screens{
    Login,
    Home
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationApp() {
    val navController = rememberNavController()

    Scaffold(topBar = {
        TopAppBar(title = { Text(text = "Navigation") })
    }){innerPadding ->
        NavHost(navController = navController,
            startDestination = Screens.Login.name,
            modifier = Modifier.padding(innerPadding)){
            composable(Screens.Login.name) { LoginScreen(login = { navController.navigate(Screens.Home.name)})}
            composable(Screens.Home.name) { HomeScreen()}

        }
    }


}

