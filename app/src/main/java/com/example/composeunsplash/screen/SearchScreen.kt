package com.example.composeunsplash.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import com.example.composeunsplash.template.search.SearchViewModel
import com.example.composeunsplash.ui.CardItem
import org.koin.androidx.compose.getViewModel

@OptIn(ExperimentalFoundationApi::class, ExperimentalCoilApi::class)
@Composable
fun SearchScreen(navController: NavHostController) {
    val viewModel = getViewModel<SearchViewModel>()
    val results = viewModel.photoSearch().observeAsState()
    results.value?.let {
        LazyVerticalGrid(cells = GridCells.Fixed(2), content = {
            itemsIndexed(items = it){
                    _, item ->  CardItem(result = item,navController)
            }
        },
            modifier = Modifier.padding(bottom = 56.dp))
    }
}

