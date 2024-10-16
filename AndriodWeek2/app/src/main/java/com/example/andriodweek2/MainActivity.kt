package com.example.andriodweek2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.andriodweek2.ui.theme.AndriodWeek2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Navigation()
//            AndriodWeek2Theme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                }
//            }
        }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Page(modifier: Modifier = Modifier, navController: NavController = rememberNavController()) {
    val dice = remember() { mutableIntStateOf(R.drawable.dice_1) }
    Column (Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceAround){
        Text("This is The Dice Roller Game")
        Column (Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally){
        Image(painter = painterResource(dice.intValue), contentDescription = "Dice")
            Button(onClick = {dice.intValue = roleDice()}) {
                Text("Role")
            }
        }
        Row (Modifier.fillMaxWidth())
        {
            Button(onClick = { navController.navigate(Screen.SecondScreen.route) }, Modifier.padding(start = 8.dp)) {
                Text("Tuto 2.3 >")
            }
        }
    }
}

fun roleDice(): Int {
    val dices = arrayOf(R.drawable.dice_1,
        R.drawable.dice_2,
        R.drawable.dice_3,
        R.drawable.dice_4,
        R.drawable.dice_5,
        R.drawable.dice_6)
    return dices.random()
}
