package com.example.superheroapp.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.superheroapp.R
import com.example.superheroapp.data.model.PowerStats

@Composable
fun PowerStatsBar(
    powerStats: PowerStats,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        PowerStatItem(
            label = stringResource(R.string.intelligence),
            value = powerStats.intelligence
        )
        PowerStatItem(
            label = stringResource(R.string.strength),
            value = powerStats.strength
        )
        PowerStatItem(
            label = stringResource(R.string.speed),
            value = powerStats.speed
        )
        PowerStatItem(
            label = stringResource(R.string.durability),
            value = powerStats.durability
        )
        PowerStatItem(
            label = stringResource(R.string.power),
            value = powerStats.power
        )
        PowerStatItem(
            label = stringResource(R.string.combat),
            value = powerStats.combat
        )
    }
}

@Composable
private fun PowerStatItem(
    label: String,
    value: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.width(80.dp)
        )
        
        Spacer(modifier = Modifier.width(8.dp))
        
        LinearProgressIndicator(
            progress = value.toIntOrNull()?.div(100f) ?: 0f,
            modifier = Modifier.weight(1f),
            color = MaterialTheme.colorScheme.primary,
            trackColor = MaterialTheme.colorScheme.surfaceVariant
        )
        
        Spacer(modifier = Modifier.width(8.dp))
        
        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.width(30.dp)
        )
    }
} 