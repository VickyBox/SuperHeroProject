package com.example.superheroapp.ui.navigation

sealed class Screen(val route: String) {
    object HeroList : Screen("hero_list")
    object HeroDetail : Screen("hero_detail/{heroId}") {
        fun createRoute(heroId: String) = "hero_detail/$heroId"
    }
} 