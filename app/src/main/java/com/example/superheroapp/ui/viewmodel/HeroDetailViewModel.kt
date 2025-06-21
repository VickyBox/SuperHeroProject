package com.example.superheroapp.ui.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.superheroapp.data.model.SuperHero
import com.example.superheroapp.data.repository.SuperHeroRepository
import com.example.superheroapp.ui.state.HeroDetailState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HeroDetailViewModel @Inject constructor(
    private val repository: SuperHeroRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    
    private val _state = MutableStateFlow(HeroDetailState())
    val state: StateFlow<HeroDetailState> = _state.asStateFlow()
    
    init {
        val heroId = savedStateHandle.get<String>("heroId")
        heroId?.let { loadHero(it) }
    }
    
    private fun loadHero(heroId: String) {
        _state.update { it.copy(isLoading = true, error = null) }
        
        viewModelScope.launch {
            repository.getHeroById(heroId).collect { result ->
                result.fold(
                    onSuccess = { hero ->
                        _state.update {
                            it.copy(
                                hero = hero,
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
    
    fun retry() {
        state.value.hero?.let { loadHero(it.id) }
    }
} 