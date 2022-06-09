package com.example.composeunsplash.template.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.composeunsplash.template.search.SearchViewModel
import com.example.composeunsplash.ui.CardItem
import com.example.composeunsplash.ui.SearchBar
import org.koin.androidx.compose.getViewModel


@Composable
fun HomeScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        val text = remember{ mutableStateOf(TextFieldValue(""))}
        Scaffold {
            Column {

                if (SearchBar(textValue = text)){
                    FetchDataSearch(navController)
                }else{
                    FetchData(navController)
                }
            }
        }


    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FetchData(navController: NavHostController){
    val viewModel = getViewModel<HomeViewModel>()
    val results = viewModel.photo().observeAsState()
    results.value?.let {
        LazyVerticalGrid(cells = GridCells.Fixed(2), content = {
            itemsIndexed(items = it){
                    _, item ->  CardItem(result = item,navController)
            }
        },
        modifier = Modifier.padding(bottom = 56.dp))
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FetchDataSearch(navController: NavHostController) {
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