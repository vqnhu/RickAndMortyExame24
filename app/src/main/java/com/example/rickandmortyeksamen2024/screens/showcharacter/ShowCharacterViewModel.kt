package com.example.rickandmortyeksamen2024.screens.showcharacter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyeksamen2024.data.Character
import com.example.rickandmortyeksamen2024.data.RickAndMortyRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ShowCharacterViewModel : ViewModel() {
    private val _showedCharacter = MutableStateFlow<Character?>(null)
    val showedCharacter = _showedCharacter.asStateFlow()

    fun setShowCharacter(id: Int){
        viewModelScope.launch {
            _showedCharacter.value = RickAndMortyRepository.getCharacterById(id)
        }
    }
}