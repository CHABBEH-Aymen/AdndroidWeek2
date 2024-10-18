package com.example.andriodweek2

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.andriodweek2.ui.theme.AndriodWeek2Theme
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SecondPage(modifier: Modifier = Modifier, navController: NavController = rememberNavController()) {
    val components = remember { mutableIntStateOf(1) }
    AndriodWeek2Theme {
        Scaffold(modifier = Modifier.fillMaxSize(), topBar = {TopBar()}) { innerPadding ->
            when (States.lemonState.value){
                1-> Leamon(innerPadding, R.drawable.lemon_tree, "Tab the lemon tree to select a lemon")
                2-> Leamon(innerPadding, R.drawable.lemon_squeeze, "Tab the lemon tree to select a lemon")
                3-> Leamon(innerPadding, R.drawable.lemon_drink, "Tab the lemon tree to select a lemon")
                4-> Leamon(innerPadding, R.drawable.lemon_restart, "Tab the lemon tree to select a lemon")
            }
        }
    }
}
@Composable
fun TopBar(){
    Row (
        Modifier
            .fillMaxWidth()
            .background(Color.Yellow)
            .height(30.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceAround){
        Text("Lemonade", fontWeight = FontWeight.Bold)
    }
}
@Composable
fun Leamon(padding: PaddingValues, image: Int, text: String)
{
    Column (Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceAround){
        Image(
            painter = painterResource(image),
            contentDescription = "Leamon Image",
            Modifier.clickable(onClick = {
                if (States.lemonState.value == 4) States.lemonState.value = 1
                else States.lemonState.value++
            })
        )
        Text(text = text)
    }
}

object States{
    val lemonState = mutableStateOf(1)
}


