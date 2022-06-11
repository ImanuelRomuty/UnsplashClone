package com.example.composeunsplash.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.composeunsplash.template.detail.DetailScreen
import com.example.composeunsplash.navigation.bottomBar.BottomBarScreen
import com.example.composeunsplash.template.favorite.FavoriteScreen
import com.example.composeunsplash.template.home.HomeScreen
import com.example.composeunsplash.screen.SearchScreen


@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route) {
            HomeScreen(navController)
        }
        composable(route = BottomBarScreen.Favorite.route) {
            FavoriteScreen(navController)
        }
        composable("DetailScreen/{photoId}"){
            DetailScreen(it.arguments?.getString("photoId"))
        }
//        composable("search_screen"){ SearchScreen(navController = navController)}
    }
}