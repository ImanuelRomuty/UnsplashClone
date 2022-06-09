package com.example.composeunsplash.ui


import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.composeunsplash.data.api.Result


@ExperimentalCoilApi
@Composable
fun CardItem(result: Result, navController: NavHostController) {
    Card(
        elevation = 10.dp,
        shape = RoundedCornerShape(15),
        modifier = Modifier
            .clickable {
                navController.navigate("DetailScreen/${result.id}")
            }
            .padding(10.dp)
            .fillMaxWidth()
            .height(210.dp),
    )
    {
        Image(
            painter = rememberImagePainter(data = result.urls?.small),
            contentDescription = "",
            modifier = Modifier
                .size(300.dp),
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,Color.Black
                        ),
                        startY = 300F
                    )
                )
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            contentAlignment = Alignment.BottomStart
        ) {
            Text(
                text = result.altDescription.toString(),
                fontSize = 12.sp,
                color = Color.White,
                modifier = Modifier.padding(5.dp)
            )
        }
    }
}

