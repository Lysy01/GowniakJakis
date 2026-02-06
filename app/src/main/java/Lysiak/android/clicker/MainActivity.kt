package Lysiak.android.clicker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import Lysiak.android.clicker.ui.theme.MyClickerTheme
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyFirstClicker()
        }
    }
}
@Composable
fun MyFirstClicker() {
    var number: MutableState<Int> = remember { mutableStateOf(0) }
    var multiplier by remember { mutableStateOf(1) }
    var isBought by remember { mutableStateOf(false) }


    Box(modifier = Modifier
        .padding(WindowInsets.statusBars.asPaddingValues())
        .fillMaxSize()
        ,




    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .background(Color.Blue)
                    .fillMaxWidth()
                    .height(100.dp)
                ,
                contentAlignment = Alignment.Center,

            ) {
                Text(text = "${number.value} $", fontSize = 40.sp, color = Color.White)
            }
            Box(
                modifier = Modifier
                    .background(Color.Red)
                    .fillMaxWidth()
                    .height(100.dp)
                    .clickable{number.value+= multiplier },
                contentAlignment = Alignment.Center
            ) {
                Row(verticalAlignment = Alignment.CenterVertically,

                    ) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "Money",
                        tint = Color.Yellow,
                        modifier = Modifier.size(40.dp)
                    )
                    Text(text = "Earn Money",
                        color = Color.White,
                        fontSize = 60.sp
                        )
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "Money",
                        tint = Color.Yellow,
                        modifier = Modifier.size(40.dp).padding(20.dp)
                    )
                }
            }
            Box(
                modifier = Modifier
                    .background(if (isBought) Color.Green else Color.Gray)
                    .clickable {
                        if (!isBought) {
                            multiplier = 2
                            isBought = true

                        }
                    }
                    .width(60.dp)
                    .height(60.dp)
                ,

            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),

                )
                {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center,
                        ) {
                    Text(text = "Upgrade multiplier to 2!")
                }
                }

            }
        }
    }
}

