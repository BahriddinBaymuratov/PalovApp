package com.example.palov.ui.screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.domain.model.Food
import com.example.palov.ui.bottom.favorite.FavoriteScreen
import com.example.palov.ui.bottom.recipes.RecipesScreen
import com.example.palov.ui.bottom.settings.SettingsScreen
import com.example.palov.ui.detail.main.DetailScreen
import com.example.palov.ui.onboarding.MainPager
import com.example.palov.ui.splash.SplashScreen
import com.example.palov.util.Graph


fun NavGraphBuilder.splashNavGraph(navHostController: NavHostController) {
    navigation(
        route = Graph.SPLASH,
        startDestination = "SPLASH"
    ) {
        composable(
            route = "SPLASH"
        ) {
            SplashScreen(navHostController)
        }
        composable(route = "ON_BOARDING") {
            MainPager(navHostController = navHostController)
        }
    }
}

@Composable
fun MainNavGraph(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        route = Graph.MAIN,
        startDestination = BottomBarScreen.Recipes.route
    ) {
        composable(route = BottomBarScreen.Recipes.route) {
            RecipesScreen(navHostController)
        }
        composable(route = BottomBarScreen.Favorite.route) {
            FavoriteScreen(navHostController)
        }
        composable(route = BottomBarScreen.Settings.route) {
            SettingsScreen()
        }
        detailNavGraph(navHostController)
    }
}

fun NavGraphBuilder.detailNavGraph(navHostController: NavHostController) {
    navigation(
        route = Graph.DETAIL,
        startDestination = "detail"
    ) {
        composable(route = "detail") {
            val food =
                navHostController.previousBackStackEntry?.savedStateHandle?.get<Food>("food")
            DetailScreen(
                navHostController = navHostController,
                food = food
            )
        }
    }
}