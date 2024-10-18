package com.example.andriodweek2
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController



@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainScreen.route)
    {
        composable(route = Screen.MainScreen.route)
        {
            Page(navController = navController)
        }
        composable(route = Screen.SecondScreen.route)
        {
            SecondPage(navController = navController)
        }
    }
}