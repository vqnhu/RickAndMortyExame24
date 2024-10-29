
package com.example.rickandmortyeksamen2024.screens.showcharacter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyeksamen2024.data.Character
import com.example.rickandmortyeksamen2024.data.RickAndMortyRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ShowCharacterViewModel : ViewModel() {
    private val _characters = MutableStateFlow<List<Character>>(emptyList())
    val characters: StateFlow<List<Character>> get() = _characters

    private val _isLoading = MutableStateFlow<Boolean>(false)
    val isLoading: StateFlow<Boolean> get() = _isLoading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> get() = _error

    private var displayedCount = 10 // Number of characters to display

    fun loadAllCharacters() {
        _isLoading.value = true
        viewModelScope.launch {
            try {
                val fetchedCharacters = RickAndMortyRepository.getAllCharacters()
                _characters.value = fetchedCharacters ?: emptyList()
            } catch (e: Exception) {
                _error.value = "Failed to load characters"
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun loadMoreCharacters() {
        displayedCount += 10 // Increase the count
        _characters.value?.let { currentList ->
            val newList = currentList.take(displayedCount)
            _characters.value = newList // Update the StateFlow with new list
        }
    }
}
