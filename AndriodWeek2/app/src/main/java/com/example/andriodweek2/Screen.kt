package com.example.andriodweek2

sealed class Screen(val route: String){
    object MainScreen: Screen("dice")
    object SecondScreen: Screen("second")
}