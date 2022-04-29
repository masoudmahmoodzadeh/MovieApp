package com.github.masoudmahmoodzadeh.movieapp.models

data class Item(
    val crew: String,
    val fullTitle: String,
    val id: String,
    val imDbRating: String,
    val imDbRatingCount: String,
    val image: String,
    val rank: String,
    val title: String,
    val year: String

) {
    fun getDirector(): String = crew.split("(dir.)")[0]
}