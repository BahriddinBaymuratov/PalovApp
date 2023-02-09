package com.example.palov.ui.screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.palov.ui.theme.MainScreen
import com.example.palov.util.Graph

@Composable
fun RootNavigation(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        route = Graph.ROOT,
        startDestination = Graph.SPLASH
    ) {
        splashNavGraph(navHostController = navHostController)
        composable(route = Graph.MAIN) {
            MainScreen()
        }
    }

}