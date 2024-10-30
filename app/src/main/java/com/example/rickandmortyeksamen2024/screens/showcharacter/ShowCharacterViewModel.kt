
package com.example.rickandmortyeksamen2024.screens.showcharacter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyeksamen2024.data.Character
import com.example.rickandmortyeksamen2024.data.RickAndMortyRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ShowCharacterViewModel : ViewModel() {
    // En ViewModel har 1 eller flere states; state for produkt
    private val _searchedCharacter = MutableStateFlow<Character?>(null)
    val searchedCharacter = _searchedCharacter.asStateFlow()


    fun setSearchedCharacter() : List<Character>? { // lage en funksjon/metode som oppdaterer state - her skal den ta imot id fra screen og få tak i produktet
        viewModelScope.launch {
            // etter endring blir det "emitet" til composable screen
            _searchedCharacter.value = RickAndMortyRepository.getAllCharacters(Character)
        }
    }
}
