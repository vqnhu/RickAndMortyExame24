package com.example.rickandmortyeksamen2024.screens.showcharacter

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun ShowCharacterScreen(showCharacterViewModel: ShowCharacterViewModel) {

    // 1. koble til screen ig ViewModel
    val showedCharacter = showCharacterViewModel.showedCharacter.collectAsState()

    // 2. pakke med ting vi må importere
    var id by remember {
        mutableStateOf<String>("")
    }

    // 3. jobbe med grensesnitt
    Column {
        Text(text = "Vis karakaterer")


    }

}


