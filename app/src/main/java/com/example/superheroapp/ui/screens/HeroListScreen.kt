package com.example.superheroapp.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.superheroapp.R
import com.example.superheroapp.ui.components.HeroCard
import com.example.superheroapp.ui.viewmodel.HeroListViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeroListScreen(
    onHeroClick: (String) -> Unit,
    viewModel: HeroListViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    var searchQuery by remember { mutableStateOf("") }
    
    LaunchedEffect(Unit) {
        viewModel.loadPopularHeroes()
    }
    
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        // 搜索栏
        SearchBar(
            query = searchQuery,
            onQueryChange = { 
                searchQuery = it
                viewModel.searchHeroes(it)
            },
            onSearch = { viewModel.searchHeroes(it) },
            active = false,
            onActiveChange = {},
            placeholder = { Text(stringResource(R.string.search_hint)) },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {}
        
        // 内容区域
        when {
            state.isLoading -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }
            
            state.error != null -> {
                ErrorContent(
                    message = state.error!!,
                    onRetry = { 
                        viewModel.clearError()
                        if (searchQuery.isBlank()) {
                            viewModel.loadPopularHeroes()
                        } else {
                            viewModel.searchHeroes(searchQuery)
                        }
                    }
                )
            }
            
            state.heroes.isEmpty() && searchQuery.isNotBlank() -> {
                EmptyContent(
                    message = stringResource(R.string.no_results_found)
                )
            }
            
            else -> {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(state.heroes) { hero ->
                        Log.i("Hero", "heroInfo=$hero")
                        HeroCard(
                            hero = hero,
                            onClick = { onHeroClick(hero.id) }
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun ErrorContent(
    message: String,
    onRetry: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = message,
                style = MaterialTheme.typography.bodyLarge
            )
            Button(onClick = onRetry) {
                Text(stringResource(R.string.retry))
            }
        }
    }
}

@Composable
private fun EmptyContent(
    message: String
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = message,
            style = MaterialTheme.typography.bodyLarge
        )
    }
} 