package com.example.composeui.practice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class ListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyColumn {
                itemsIndexed(
                    listOf(
                        "This",
                        "is",
                        "Jetpack",
                        "Compose",
                        "This",
                        "is",
                        "Jetpack",
                        "Compose",
                        "This",
                        "is",
                        "Jetpack",
                        "Compose",
                        "This",
                        "is",
                        "Jetpack",
                        "Compose"
                    )
                ) { index, item ->
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp),
                        textAlign = TextAlign.Center,
                        text = "Item $item", fontWeight = FontWeight.Bold,
                        fontSize = 24.sp
                    )
                }
            }
        }
    }
}
