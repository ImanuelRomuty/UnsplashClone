package com.example.composeunsplash.template

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.composeunsplash.DetailScreen
import com.example.composeunsplash.SearchScreenRemake
import com.example.composeunsplash.screen.FavoriteScreen
import com.example.composeunsplash.screen.HomeScreen
import com.example.composeunsplash.screen.SearchScreen


@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route) {
            HomeScreen(navController)
        }
        composable(route = BottomBarScreen.Favorite.route) {
            FavoriteScreen()
        }
        composable("DetailScreen/{photoId}"){
            DetailScreen(it.arguments?.getString("photoId"))
        }
        composable("search_screen"){ SearchScreen(navController = navController)}
        composable("search_screen_remake"){ SearchScreenRemake(navController = navController)}
    }
}