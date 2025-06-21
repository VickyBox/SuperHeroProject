package com.example.superheroapp.ui.state

import com.example.superheroapp.data.model.SuperHero

sealed class UiState<out T> {
    object Loading : UiState<Nothing>()
    data class Success<T>(val data: T) : UiState<T>()
    data class Error(val message: String) : UiState<Nothing>()
}

data class HeroListState(
    val heroes: List<SuperHero> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
    val searchQuery: String = ""
)

data class HeroDetailState(
    val hero: SuperHero? = null,
    val isLoading: Boolean = false,
    val error: String? = null
) 