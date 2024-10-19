package com.example.citysites

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.citysites.ui.theme.CitySitesTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CitySitesTheme {
                Scaffold(topBar = {
                    CenterAlignedTopAppBar(
                        title = { Text("Sidi Bou Said") },
                        colors = TopAppBarColors(
                            containerColor = Color.Cyan,
                            scrolledContainerColor = Color.Cyan,
                            navigationIconContentColor = Color.Cyan,
                            titleContentColor = Color.Black,
                            actionIconContentColor = Color.Cyan
                        )
                    )
                }) { innerPadding ->
                    Surface(modifier = Modifier.padding(innerPadding)) {
                        MainPage()
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainPage(modifier: Modifier = Modifier) {
    when (States.lemonState.value){
        1-> Leamon( R.drawable.sidi_bou_said_1, "Sidi Bou Said Mosque")
        2-> Leamon(R.drawable.sidi_bou_said_2, "Sidi Bou Said Entirence")
        3-> Leamon(R.drawable.sidi_bou_said_3, "Sidi Bou Said Hotel")
        4-> Leamon(R.drawable.sidi_bou_said_4, "Sidi Bou Said Streets")
    }

}

@Composable
fun Leamon(image: Int, text: String)
{
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Card (Modifier.fillMaxWidth().padding(start = 18.dp, end = 18.dp).height(350.dp)){
            Column (Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally,verticalArrangement = Arrangement.Center){
                Image(
                    painter = painterResource(image),
                    contentDescription = "Leamon Image",
                    Modifier.clickable(onClick = {
                        if (States.lemonState.value == 4) States.lemonState.value = 1
                        else States.lemonState.value++
                    }).width(300.dp).height(300.dp).clip(RoundedCornerShape(40.dp)),

                )
                Text(text = text, textAlign = TextAlign.Center)
            }
        }
    }
}

object States{
    val lemonState = mutableStateOf(1)
}
