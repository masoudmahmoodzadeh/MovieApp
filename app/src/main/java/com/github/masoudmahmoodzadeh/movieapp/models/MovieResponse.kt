package com.github.masoudmahmoodzadeh.movieapp.models

data class MovieResponse(
    val errorMessage: String,
    val items: List<Item>
)