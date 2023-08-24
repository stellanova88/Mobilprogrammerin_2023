package com.example.oppskrift

import android.os.Bundle
import android.widget.GridLayout.Alignment
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
    Column (
        modifier = Modifier
            .padding(15.dp)



        ){
        Image(
            painterResource(R.drawable.ivan_torres_mquqbmszggm_unsplash),
            contentDescription = "Pizza",
            modifier = Modifier.clip(RoundedCornerShape(10.dp))
        )
        Text(text = "Pizza",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(10.dp),
            fontSize = 30.sp,
        )
//        Icon(R.drawable.timer_fill0_wght400_grad0_opsz48, contentDescription = "Timer")
        Row (
            modifier = Modifier
                .fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ){
            Box(modifier = Modifier ){
                Row(modifier = Modifier) {
                    Icon(Icons.Default.Refresh, contentDescription = "Timer")
                    Spacer(modifier = Modifier.size(10.dp))
                    Text(text = "45min")
                }
            }
            Box(modifier = modifier){
                Row(modifier = Modifier) {
                    Icon(Icons.Filled.Favorite, contentDescription = "Heart")
                    Icon(Icons.Filled.Favorite, contentDescription = "Heart")
                    Icon(Icons.Filled.Favorite, contentDescription = "Heart")
                    Icon(Icons.Filled.Favorite, contentDescription = "Heart")
                    Icon(Icons.Outlined.FavoriteBorder , contentDescription = null)
                    Spacer(modifier = Modifier.size(10.dp))
                    Text(text = "4.0")
                }
            }


        }



    }
    
    
}

@Preview(showBackground = true)
@Composable
fun OppskriftPreview() {
    Oppskrift(modifier = Modifier
//        .fillMaxSize()
        .wrapContentSize()
    )
}