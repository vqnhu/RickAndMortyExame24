package com.example.rickandmortyeksamen2024

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.rickandmortyeksamen2024.screens.showcharacter.ShowCharacterScreen
import com.example.rickandmortyeksamen2024.screens.showcharacter.ShowCharacterViewModel
import com.example.rickandmortyeksamen2024.ui.theme.RickAndMortyEksamen2024Theme

class MainActivity : ComponentActivity() {

    private val _showCharacterViewModel: ShowCharacterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RickAndMortyEksamen2024Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding)) {
                        ShowCharacterScreen(_showCharacterViewModel)
                    }
                }
            }
        }
    }
}
