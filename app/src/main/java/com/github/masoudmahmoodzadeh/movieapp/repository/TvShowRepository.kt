package com.github.masoudmahmoodzadeh.movieapp.repository

import com.github.masoudmahmoodzadeh.movieapp.api.ApiService
import javax.inject.Inject

class TvShowRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getMovies() = apiService.getMovies()

}