package com.example.lemonade

import android.icu.text.CaseMap.Title
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    LemonadePreview()
                }
            }
        }
    }
}

@Composable
fun Lemonade( modifier: Modifier = Modifier){
    var currentStep by remember { mutableStateOf(1) }
    var squeezeCount by remember { mutableStateOf(0) }
    when (currentStep) {
        1 -> LemonTextAndImage(
            imageName = R.drawable.lemon_tree,
            imageDescriptionText = R.string.Lemon_tree,
            imageText = R.string.lemon_tree_text,
            goNextImage = {currentStep = 2
                squeezeCount = (2..4).random()
            },
            modifier = modifier
        )
        2 -> LemonTextAndImage(
            imageName = R.drawable.lemon_squeeze,
            imageDescriptionText = R.string.Lemon,
            imageText = R.string.lemon_squeeze_text,
            goNextImage = {
                squeezeCount --
                if (squeezeCount == 0) {
                    currentStep = 3
                }
            },
            modifier = modifier
        )
        3 -> LemonTextAndImage(
            imageName = R.drawable.lemon_drink,
            imageDescriptionText = R.string.Glass_of_lemonade,
            imageText = R.string.lemon_drink_text,
            goNextImage = {currentStep = 4},
            modifier = modifier
        )
        4 -> LemonTextAndImage(
            imageName = R.drawable.lemon_restart,
            imageDescriptionText = R.string.Empty_glass,
            imageText = R.string.lemon_restart_text,
            goNextImage = {currentStep = 1},
            modifier = modifier
        )
    }
}

@Composable
fun LemonTextAndImage(imageName: Int,
                      imageDescriptionText: Int,
                      imageText: Int,
                      goNextImage: () -> Unit,
                      modifier: Modifier = Modifier){

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier,
        ) {
        Button(
            onClick = goNextImage,
            shape = RoundedCornerShape(35.dp),
            ) {
            Image(
                painterResource(imageName),
                contentDescription = stringResource(imageDescriptionText),
                modifier = Modifier.padding(25.dp)
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = stringResource(imageText)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LemonadePreview(){
    Lemonade(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center))
}