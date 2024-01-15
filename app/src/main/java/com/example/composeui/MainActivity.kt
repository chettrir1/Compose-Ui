package com.example.composeui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            /*   val painter = painterResource(id = R.drawable.olaf)
               val description = "Karmit in the snow"
               val title = "Karmit is playing in the snow"
               ImageCard(
                   painter = painter, contentDescription = description, title = title
               )

               val fontFamily = FontFamily(
                   Font(R.font.lexend_thin, FontWeight.Thin),
                   Font(R.font.lexend_semi_bold, FontWeight.SemiBold),
                   Font(R.font.lexend_regular, FontWeight.Normal),
                   Font(R.font.lexend_medium, FontWeight.Medium),
                   Font(R.font.lexend_light, FontWeight.Light),
                   Font(R.font.lexend_extra_light, FontWeight.ExtraLight),
                   Font(R.font.lexend_extra_bold, FontWeight.ExtraBold),
                   Font(R.font.lexend_bold, FontWeight.Bold),
                   Font(R.font.lexend_black, FontWeight.Black)
               )
               CustomText(title = "Jetpack Compose", fontFamily = fontFamily)

             */
            Column(modifier = Modifier.fillMaxSize()) {
                val color = remember {
                    mutableStateOf(Color.Yellow)
                }
                ColorBox(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxSize()
                ) {
                    color.value = it
                }
                Box(
                    modifier = Modifier
                        .background(color = color.value)
                        .weight(1f)
                        .fillMaxSize()
                )
            }

        }
    }
}

@Composable
fun ImageCard(
    painter: Painter, contentDescription: String, title: String, modifier: Modifier = Modifier
) {
    Box(modifier = Modifier.padding(16.dp)) {
        Card(
            modifier = modifier.fillMaxWidth(), shape = RoundedCornerShape(16.dp)
        ) {
            Box(modifier = Modifier.height(200.dp)) {
                Image(
                    modifier = Modifier.fillMaxSize(),
                    painter = painter,
                    contentDescription = contentDescription,
                    contentScale = ContentScale.Crop
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    Color.Transparent, Color.Black
                                ),
                                startY = 400f,
                            )
                        )
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(12.dp),
                    contentAlignment = Alignment.BottomStart
                ) {
                    Text(text = title, style = TextStyle(color = Color.White, fontSize = 16.sp))
                }
            }
        }
    }
}

@Composable
fun CustomText(
    modifier: Modifier = Modifier, title: String, fontFamily: FontFamily
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color(0xFF101010))
            .padding(16.dp),
    ) {
        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = Color.Green, fontSize = 50.sp
                    )
                ) {
                    append("J")
                }
                append("etpack ")
                withStyle(
                    style = SpanStyle(
                        color = Color.Green, fontSize = 50.sp
                    )
                ) {
                    append("C")
                }
                append("ompose ")
            }, style = TextStyle(
                color = Color.White,
                fontFamily = fontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                fontStyle = FontStyle.Italic,
                textAlign = TextAlign.Center,
                textDecoration = TextDecoration.Underline
            )
        )

    }
}

@Composable
fun ColorBox(modifier: Modifier = Modifier, updateColor: (Color) -> Unit) {
    Box(modifier = modifier
        .background(Color.Red)
        .clickable {
            updateColor(
                Color(
                    Random.nextFloat(),
                    Random.nextFloat(),
                    Random.nextFloat(),
                    1f
                )
            )
        }) {
    }
}
