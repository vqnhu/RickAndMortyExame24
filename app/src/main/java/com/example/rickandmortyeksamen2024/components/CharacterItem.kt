package com.example.rickandmortyeksamen2024.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImage

@Composable
fun CharacterItem(character: Character) {

    Column {
        Text(text = character.name)
        //AsyncImage
        Text(text = character.species)
        Text(text = "hahaha")
    }
}




