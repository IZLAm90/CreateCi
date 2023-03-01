package com.example.cicdprojectone

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cicdprojectone.ui.theme.Shapes
import kotlin.text.Typography

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun expandableCard(){
    var remmeber by remember { mutableStateOf(false) }
    val rotation by animateFloatAsState(targetValue =  if (remmeber) 180f else 0f)
    Card(modifier = Modifier
        .fillMaxWidth()
        .animateContentSize(
            animationSpec =
            tween(durationMillis = 300, easing = LinearOutSlowInEasing)
        ), shape = Shapes.medium,
        onClick = {remmeber=!remmeber}) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = "Title", modifier = Modifier.weight(6f), maxLines = 1, overflow = TextOverflow.Ellipsis,
                     fontSize = MaterialTheme.typography.h6.fontSize, fontWeight = FontWeight.Bold)
                IconButton(modifier = Modifier
                    .alpha(ContentAlpha.medium)
                    .weight(1f)
                    .rotate(rotation)
                    ,onClick = { remmeber=!remmeber}) {
                    Icon(imageVector=Icons.Default.ArrowDropDown,contentDescription="islam")
                }
            }
            if (remmeber){
                Text(text = "sdddddddddddddddddddddddddddddddddddddddddddddd" +
                        "sddddddddddddddswwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww" +
                        "wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwweeeeeeeeeeeeeee" +
                        "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee", fontWeight = FontWeight.Normal
                , fontSize = MaterialTheme.typography.h6.fontSize,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 4
                )
            }
        }
    }
}

@Composable
@Preview
fun cardPreview(){
    expandableCard()
}