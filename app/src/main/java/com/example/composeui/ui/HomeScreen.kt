package com.example.composeui.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.composeui.R
import com.example.composeui.ui.theme.ButtonBlue
import com.example.composeui.ui.theme.DarkerButtonBlue
import com.example.composeui.ui.theme.DeepBlue
import com.example.composeui.ui.theme.LightRed
import com.example.composeui.ui.theme.TextWhite

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .background(DeepBlue)
            .fillMaxSize()
    ) {
        Column {
            GreetingSection()
            ChipSection(chips = listOf("Sweet Sleep", "Insomnia", "Depression"))
            CurrentMeditation()

        }

    }
}

@Composable
fun GreetingSection(
    name: String = "Raju"
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Good morning, $name",
                style = MaterialTheme.typography.headlineSmall,
                color = TextWhite
            )
            Text(
                text = "We wish you have a good day",
                style = MaterialTheme.typography.bodyMedium,
                color = TextWhite
            )
        }
        Icon(
            painter = painterResource(id = R.drawable.ic_search),
            contentDescription = "Search",
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )
    }
}

@Composable
fun ChipSection(
    chips: List<String>
) {
    var selectedChipIndex by remember {
        mutableStateOf(0)
    }
    LazyRow {
        items(chips.size) {
            Box(modifier = Modifier
                .padding(
                    start = 16.dp, top = 16.dp, bottom = 16.dp, end = 0.dp
                )
                .clickable {
                    selectedChipIndex = it
                }
                .clip(RoundedCornerShape(16.dp))
                .background(
                    if (selectedChipIndex == it) ButtonBlue
                    else DarkerButtonBlue
                )
                .padding(16.dp)) {
                Text(text = chips[it], color = TextWhite)
            }
        }
    }
}

@Composable
fun CurrentMeditation(color: Color = LightRed) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(16.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(color)
            .padding(horizontal = 16.dp, vertical = 20.dp)
            .fillMaxWidth()
    ) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Daily Thought",
                style = MaterialTheme.typography.headlineSmall,
                color = TextWhite
            )
            Text(
                text = "Meditation * 3-10 min ",
                style = MaterialTheme.typography.bodySmall,
                color = TextWhite
            )
        }
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(ButtonBlue)
                .padding(12.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_play),
                contentDescription = "Search",
                tint = Color.White,
                modifier = Modifier.size(16.dp)
            )
        }
    }

}