package com.example.oppskrift

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.oppskrift.ui.theme.OppskriftTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OppskriftTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    OppskriftPreview()
                }
            }
        }
    }
}

@Composable
fun Oppskrift(modifier: Modifier = Modifier){
    Column (modifier = modifier

        ){
        Image(
            painterResource(R.drawable.ivan_torres_mquqbmszggm_unsplash),
            contentDescription = "Pizza",
            modifier.padding(15.dp))
        Text(text = "Pizza")
//        Icon(R.drawable.timer_fill0_wght400_grad0_opsz48, contentDescription = "Timer")
        Icon(Icons.Default.Refresh, contentDescription = "Timer")

    }
    
    
}

@Preview(showBackground = true)
@Composable
fun OppskriftPreview() {
    Oppskrift(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.TopCenter)
    )
}