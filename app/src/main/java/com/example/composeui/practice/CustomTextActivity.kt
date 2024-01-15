package com.example.composeui.practice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeui.R

class CustomTextActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

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
}
