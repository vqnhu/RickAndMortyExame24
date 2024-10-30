package com.example.rickandmortyeksamen2024.screens.showcharacter

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.rickandmortyeksamen2024.components.CharacterItem
import com.example.rickandmortyeksamen2024.data.Character

@Composable
fun ShowCharacterScreen(showCharacterViewModel: ShowCharacterViewModel) {

    // 1. koble til screen og ViewModel
    val showCharacters = showCharacterViewModel.showCharacters.collectAsState()

    // 2. pakke med ting vi må importere
    var name by remember {
        mutableStateOf("")
    }

    // 3. jobbe med grensesnitt
    Column {
        Text(text = "Vis karakaterer")

        LazyColumn {
            items(showCharacters.value){ showCharacter ->
                Text(text = showCharacter.name)

            }
        }


    }

}


