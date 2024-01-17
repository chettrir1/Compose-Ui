package com.example.composeui.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeui.R

@Composable
fun ProfileScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        TopBar(name = "chettrir1")
        ProfileSection()
        Spacer(modifier = Modifier.height(20.dp))
        ButtonSection(modifier = Modifier.fillMaxWidth())
    }
}

@Composable
fun TopBar(
    name: String, modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
            .fillMaxWidth()
            .padding(
                top = 16.dp, bottom = 16.dp
            )
    ) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = "arrowBack",
            tint = Color.Black,
            modifier = Modifier
                .size(24.dp)
                .weight(1f)
        )
        Text(
            text = name,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier.weight(5.5f)
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_bell),
            contentDescription = "bell",
            tint = Color.Black,
            modifier = Modifier
                .size(24.dp)
                .weight(1f)
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_dotmenu),
            contentDescription = "dotmenu",
            tint = Color.Black,
            modifier = Modifier
                .size(20.dp)
                .weight(1f)
        )
    }
}

@Composable
fun ProfileSection(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxWidth()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)

        ) {
            RoundImage(
                image = painterResource(id = R.drawable.phillip),
                modifier = Modifier
                    .size(100.dp)
                    .weight(3f)
            )
            Spacer(modifier = Modifier.width(16.dp))
            StatSection(modifier = Modifier.weight(7f))
        }

        ProfileDescription(
            displayName = "Programming Mentor",
            description = "10 years of coding experience\n" + "Want me to make your app? Send me email!\n" + "Subscribe to my youtube Channel!",
            url = "https://youtube.com",
            followedBy = listOf("codingflow", "miakalifa"),
            otherCount = 17
        )
    }
}

@Composable
fun RoundImage(
    image: Painter, modifier: Modifier = Modifier
) {
    Image(
        painter = image,
        contentDescription = "profile",
        contentScale = ContentScale.Crop,
        modifier = modifier
            .aspectRatio(
                1f, matchHeightConstraintsFirst = true
            )
            .border(
                width = 1.dp, color = Color.LightGray, shape = CircleShape
            )
            .padding(3.dp)
            .clip(CircleShape)
    )
}

@Composable
fun StatSection(
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
    ) {
        ProfileStats(numberText = "601", text = "Posts")
        ProfileStats(numberText = "100K", text = "Followers")
        ProfileStats(numberText = "72", text = "Following")
    }
}

@Composable
fun ProfileStats(
    numberText: String, text: String, modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = numberText, fontWeight = FontWeight.Bold, fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = text,
        )
    }
}

@Composable
fun ProfileDescription(
    displayName: String,
    description: String,
    url: String,
    followedBy: List<String>,
    otherCount: Int,
    modifier: Modifier = Modifier
) {
    val letterSpacing = 0.5.sp
    val lineHeight = 20.sp
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        Text(
            text = displayName,
            fontWeight = FontWeight.Bold,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        Text(
            text = description, letterSpacing = letterSpacing, lineHeight = lineHeight
        )
        Text(
            text = url,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight,
            color = Color(0xFF3D3D91)
        )
        if (followedBy.isNotEmpty()) {
            Text(
                text = buildAnnotatedString {
                    val boldStyle = SpanStyle(
                        color = Color.Black, fontWeight = FontWeight.Bold
                    )
                    append("Followed by ")
                    followedBy.forEachIndexed { index, name ->
                        pushStyle(boldStyle)
                        append(name)
                        pop()
                        if (index < followedBy.size - 1) {
                            append(", ")
                        }
                    }
                    if (otherCount > 2) {
                        append(" and ")
                        pushStyle(boldStyle)
                        append("$otherCount others")
                    }
                }, letterSpacing = letterSpacing, lineHeight = lineHeight
            )
        }
    }
}

@Composable
fun ButtonSection(
    modifier: Modifier = Modifier
) {
    val minWidth = 95.dp
    val height = 30.dp
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly, modifier = modifier
    ) {
        ActionButton(
            text = "Following",
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )

        ActionButton(
            text = "Message",
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )
        ActionButton(
            text = "Email",
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )
        ActionButton(
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .height(height)
        )
    }
}

@Composable
fun ActionButton(
    modifier: Modifier = Modifier,
    text: String? = null,
    icon: ImageVector? = null
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(5.dp)
            )
            .padding(6.dp)
    ) {
        if (text != null) {
            Text(
                text = text,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp
            )
        }
        if (icon != null) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color.Black
            )
        }
    }
}