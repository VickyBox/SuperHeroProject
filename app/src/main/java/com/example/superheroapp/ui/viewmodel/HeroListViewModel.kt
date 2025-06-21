package com.example.superheroapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.superheroapp.data.model.SuperHero
import com.example.superheroapp.data.repository.SuperHeroRepository
import com.example.superheroapp.ui.state.HeroListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HeroListViewModel @Inject constructor(
    private val repository: SuperHeroRepository
) : ViewModel() {
    
    private val _state = MutableStateFlow(HeroListState())
    val state: StateFlow<HeroListState> = _state.asStateFlow()
    
    fun searchHeroes(query: String) {
        if (query.isBlank()) {
            _state.update { it.copy(heroes = emptyList(), searchQuery = query) }
            return
        }
        
        _state.update { it.copy(isLoading = true, error = null, searchQuery = query) }
        
        viewModelScope.launch {
            repository.searchHeroes(query).collect { result ->
                result.fold(
                    onSuccess = { heroes ->
                        _state.update {
                            it.copy(
                                heroes = heroes,
                                isLoading = false,
                                error = null
                            )
                        }
                    },
                    onFailure = { exception ->
                        _state.update {
                            it.copy(
                                isLoading = false,
                                error = exception.message ?: "資料載入失敗"
                            )
                        }
                    }
                )
            }
        }
    }
    
    fun clearError() {
        _state.update { it.copy(error = null) }
    }
    
    fun loadPopularHeroes() {
        // 加载一些热门英雄的ID
        val popularHeroIds = listOf("644", "149", "106", "213", "620", "720", "370", "659")
        
        _state.update { it.copy(isLoading = true, error = null) }
        
        viewModelScope.launch {
            repository.getHeroesByIds(popularHeroIds).collect { result ->
                result.fold(
                    onSuccess = { heroes ->
                        _state.update {
                            it.copy(
                                heroes = heroes,
                                isLoading = false,
                                error = null
                            )
                        }
                    },
                    onFailure = { exception ->
                        _state.update {
                            it.copy(
                                isLoading = false,
                                error = exception.message ?: "資料載入失敗"
                            )
                        }
                    }
                )
            }
        }
    }
} 