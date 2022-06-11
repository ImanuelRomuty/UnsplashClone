package com.example.composeunsplash.template.favorite

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.composeunsplash.ui.CardItemFavorite
import org.koin.androidx.compose.getViewModel

@Composable
fun FavoriteScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {

        FetchDataFavorite(navController)
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FetchDataFavorite(navController: NavHostController){
    val viewModel = getViewModel<FavoriteViewModel>()
    val results = viewModel.photo().observeAsState()
    results.value?.let {
        LazyVerticalGrid(cells = GridCells.Fixed(2), content = {
            itemsIndexed(items = it){
                    _, item ->  CardItemFavorite(result = item,navController)
            }
        },
            modifier = Modifier.padding(bottom = 56.dp))
    }
}

