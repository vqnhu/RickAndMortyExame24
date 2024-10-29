package com.example.rickandmortyeksamen2024.data

data class CharacterList(
    val info: Info,
    val results: List<Character>
)

data class Info(
    val count: Int,      // Total number of characters
    val pages: Int,      // Total number of pages
    val next: String?,    // URL of the next page (null if there is no next page)
    val prev: String?     // URL of the previous page (null if there is no previous page)
)
