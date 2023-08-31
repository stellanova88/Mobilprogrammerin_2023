package com.example.playingwithstate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.playingwithstate.ui.theme.PlayingWithStateTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlayingWithStateTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}

@Composable
fun ColorCHangingButton(backgroundColor: Color,
                        updateColor: (Color) -> Unit,
                        modifier: Modifier = Modifier
    ){
//    var backgroundColor by remember { mutableStateOf(Color.Cyan) }

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
        ){
            Button(onClick = {
//                if (backgroundColor == Color.White)
//                    backgroundColor = Color.Cyan
//                else
//                    backgroundColor = Color.White

                val newColor = when(backgroundColor) { //when: En slags if else/switch case
                    Color.White -> Color.Cyan
                    Color.Cyan -> Color.Magenta
                    else -> Color.White
                }

                updateColor(newColor)
            }) {
                Text(text = stringResource(R.string.change_color))
            }
    }
}

@Composable
fun ColorChangingScreen (modifier: Modifier = Modifier){
    var backgroundColorTop by remember { mutableStateOf(Color.Cyan) }
    var backgroundColorBottom by remember { mutableStateOf(Color.Cyan) }

    Column(verticalArrangement = Arrangement.SpaceEvenly) {
        ColorCHangingButton(backgroundColor = backgroundColorTop,
            updateColor = {newColor -> backgroundColorTop = newColor},
            modifier = Modifier.weight(2.0f))
        ColorCHangingButton(backgroundColor = backgroundColorBottom,
            updateColor = {newColor -> backgroundColorBottom = newColor},
            modifier = Modifier.weight(1.0f))
    }

}

@Preview(showBackground = true)
@Composable
fun ColorChangingButtonPreview() {
    PlayingWithStateTheme {
        ColorChangingScreen()
    }
}