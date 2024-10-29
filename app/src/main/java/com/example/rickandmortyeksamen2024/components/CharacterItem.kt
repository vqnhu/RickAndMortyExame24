package com.example.rickandmortyeksamen2024.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import coil.compose.AsyncImage
import com.example.rickandmortyeksamen2024.data.Character

@Composable
fun CharacterItem(character: Character) {
    Column {
        Text(text = character.name)
        AsyncImage(
            model = character.image,
            contentDescription = "Image of ${character.name}"
        )
        Text(text = character.species) // Displays the species if needed
    }
    /// OBS
}
