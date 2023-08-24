package com.example.oppskrift

import android.os.Bundle
import android.widget.GridLayout.Alignment
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
    Card (modifier = Modifier
        .padding(5.dp)
    ){
        Column(
            modifier = Modifier
                .padding(15.dp)
        ) {
            Image(
                painterResource(id = R.drawable.ivan_torres_mquqbmszggm_unsplash),
                contentDescription = stringResource(R.string.image_pizza),
                modifier = Modifier.clip(RoundedCornerShape(10.dp))
            )
            Text(
                text = "Pizza",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(10.dp),
                fontSize = 30.sp,
            )

//        Icon(Painter = R.drawable.timer_fill0_wght400_grad0_opsz48, contentDescription = stringResource(R.string.Icon_timer))
            Row(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Box(modifier = Modifier) {
                    Row(modifier = Modifier) {
                        Icon(
                            painterResource(id = R.drawable.timer_fill0_wght400_grad0_opsz48),
                            contentDescription = stringResource(R.string.Icon_timer),
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(
                            modifier = Modifier.size(10.dp)

                        )
                        Text(text = stringResource(R.string._45_min))
                    }
                }
                Box(modifier = modifier) {
                    Row(
                    ) {
                        Icon(
                            painterResource(id = R.drawable.star_fill),
                            contentDescription = stringResource(R.string.Icon_heart),
                            modifier = Modifier
                                .size(20.dp)
                        )
                        Icon(
                            painterResource(id = R.drawable.star_fill),
                            contentDescription = stringResource(R.string.Icon_heart),
                            modifier = Modifier
                                .size(20.dp)
                        )
                        Icon(
                            painterResource(id = R.drawable.star_fill),
                            contentDescription = stringResource(R.string.Icon_heart),
                            modifier = Modifier
                                .size(20.dp)
                        )
                        Icon(
                            painterResource(id = R.drawable.star_fill),
                            contentDescription = stringResource(R.string.Icon_heart),
                            modifier = Modifier
                                .size(20.dp)
                        )

                        Icon(
                            painterResource(id = R.drawable.star),
                            contentDescription = stringResource(R.string.Icon_heart),
                            modifier = Modifier
                                .size(20.dp)
                        )
                        Spacer(modifier = Modifier.size(10.dp))
                        Text(text = stringResource(R.string.Rating_value)
                        )
                    }
                }
            }
//        Icon(Icons.Default.Star, contentDescription = null)

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