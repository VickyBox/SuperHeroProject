package com.example.superheroapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.superheroapp.ui.screens.HeroDetailScreen
import com.example.superheroapp.ui.screens.HeroListScreen

@Composable
fun NavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.HeroList.route
    ) {
        composable(Screen.HeroList.route) {
            HeroListScreen(
                onHeroClick = { heroId ->
                    navController.navigate(Screen.HeroDetail.createRoute(heroId))
                }
            )
        }
        
        composable(
            route = Screen.HeroDetail.route,
            arguments = listOf(
                navArgument("heroId") {
                    type = NavType.StringType
                }
            )
        ) {
            HeroDetailScreen(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
} 