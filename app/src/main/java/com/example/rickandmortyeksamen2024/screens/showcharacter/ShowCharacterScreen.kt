package com.example.rickandmortyeksamen2024.screens.showcharacter

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import com.example.rickandmortyeksamen2024.components.CharacterItem
import com.example.rickandmortyeksamen2024.data.Character
import com.example.rickandmortyeksamen2024.data.RickAndMortyRepository
import kotlinx.coroutines.launch

@Composable
fun ShowCharacterScreen(showCharacterViewModel: ShowCharacterViewModel) {

    // 1. koble til screen og ViewModel
    val showCharacters = showCharacterViewModel.showCharacters.collectAsState()

    // 2. pakke med ting vi må importere
    var name by remember {
        mutableStateOf<List<Character>>(emptyList())
    }

    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        coroutineScope.launch {
            name = RickAndMortyRepository.getAllCharacters()
        }
    }

    // 3. jobbe med grensesnitt
    Column {
        Text(text = "Vis karakaterer")

        LazyColumn {
            items(name){ showCharacter ->
                CharacterItem(showCharacter)


            }
        }


    }

}


