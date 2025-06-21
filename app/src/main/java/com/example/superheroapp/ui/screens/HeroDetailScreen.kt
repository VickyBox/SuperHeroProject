package com.example.superheroapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.superheroapp.R
import com.example.superheroapp.ui.components.PowerStatsBar
import com.example.superheroapp.ui.viewmodel.HeroDetailViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeroDetailScreen(
    onBackClick: () -> Unit,
    viewModel: HeroDetailViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(state.hero?.name ?: "") },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "返回")
                    }
                }
            )
        }
    ) { paddingValues ->
        when {
            state.isLoading -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }
            
            state.error != null -> {
                ErrorContent(
                    message = state.error!!,
                    onRetry = { viewModel.retry() },
                    modifier = Modifier.padding(paddingValues)
                )
            }
            
            state.hero != null -> {
                HeroDetailContent(
                    hero = state.hero!!,
                    modifier = Modifier.padding(paddingValues)
                )
            }
        }
    }
}

@Composable
private fun HeroDetailContent(
    hero: com.example.superheroapp.data.model.SuperHero,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // 英雄图片和基本信息
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(hero.image.url)
                    .crossfade(true)
                    .build(),
                contentDescription = hero.name,
                modifier = Modifier
                    .size(120.dp)
                    .clip(RoundedCornerShape(12.dp)),
                contentScale = ContentScale.Crop
            )
            
            Spacer(modifier = Modifier.width(16.dp))
            
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = hero.name,
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold
                )
                
                Spacer(modifier = Modifier.height(8.dp))
                
                Text(
                    text = stringResource(R.string.full_name) + ": ${hero.biography.fullName}",
                    style = MaterialTheme.typography.bodyMedium
                )
                
                Text(
                    text = stringResource(R.string.publisher) + ": ${hero.biography.publisher}",
                    style = MaterialTheme.typography.bodyMedium
                )
                
                Text(
                    text = stringResource(R.string.alignment) + ": ${
                        when (hero.biography.alignment) {
                            "good" -> stringResource(R.string.good)
                            "bad" -> stringResource(R.string.bad)
                            else -> stringResource(R.string.neutral)
                        }
                    }",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
        
        // 能力值
        Card(
            shape = RoundedCornerShape(12.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = stringResource(R.string.powerstats),
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                
                Spacer(modifier = Modifier.height(12.dp))
                
                PowerStatsBar(powerStats = hero.powerstats)
            }
        }
        
        // 背景故事
        InfoCard(
            title = stringResource(R.string.biography),
            content = {
                Column {
                    InfoRow(stringResource(R.string.alter_egos), hero.biography.alterEgos)
                    if (hero.biography.aliases.isNotEmpty()) {
                        InfoRow(stringResource(R.string.aliases), hero.biography.aliases.joinToString(", "))
                    }
                    InfoRow(stringResource(R.string.place_of_birth), hero.biography.placeOfBirth)
                    InfoRow(stringResource(R.string.first_appearance), hero.biography.firstAppearance)
                }
            }
        )
        
        // 外观
        InfoCard(
            title = stringResource(R.string.appearance),
            content = {
                Column {
                    InfoRow(stringResource(R.string.gender), hero.appearance.gender)
                    InfoRow(stringResource(R.string.race), hero.appearance.race)
                    if (hero.appearance.height.isNotEmpty()) {
                        InfoRow(stringResource(R.string.height), hero.appearance.height.joinToString(", "))
                    }
                    if (hero.appearance.weight.isNotEmpty()) {
                        InfoRow(stringResource(R.string.weight), hero.appearance.weight.joinToString(", "))
                    }
                    InfoRow(stringResource(R.string.eye_color), hero.appearance.eyeColor)
                    InfoRow(stringResource(R.string.hair_color), hero.appearance.hairColor)
                }
            }
        )
        
        // 职业
        InfoCard(
            title = stringResource(R.string.work),
            content = {
                Column {
                    InfoRow(stringResource(R.string.occupation), hero.work.occupation)
                    InfoRow(stringResource(R.string.base), hero.work.base)
                }
            }
        )
        
        // 关联
        InfoCard(
            title = stringResource(R.string.connections),
            content = {
                Column {
                    InfoRow(stringResource(R.string.group_affiliation), hero.connections.groupAffiliation)
                    InfoRow(stringResource(R.string.relatives), hero.connections.relatives)
                }
            }
        )
    }
}

@Composable
private fun InfoCard(
    title: String,
    content: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(12.dp),
        modifier = modifier
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            
            Spacer(modifier = Modifier.height(12.dp))
            
            content()
        }
    }
}

@Composable
private fun InfoRow(
    label: String,
    value: String,
    modifier: Modifier = Modifier
) {
    if (value != "-" && value.isNotBlank()) {
        Row(
            modifier = modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top
        ) {
            Text(
                text = label + ":",
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.width(100.dp)
            )
            
            Spacer(modifier = Modifier.width(8.dp))
            
            Text(
                text = value,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.weight(1f)
            )
        }
        
        Spacer(modifier = Modifier.height(4.dp))
    }
}

@Composable
private fun ErrorContent(
    message: String,
    onRetry: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize(),
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