package com.github.masoudmahmoodzadeh.movieapp.api

import com.github.masoudmahmoodzadeh.movieapp.helper.Constants
import com.github.masoudmahmoodzadeh.movieapp.models.MovieResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(Constants.END_POINT)
    suspend fun getMovies(): Response<MovieResponse>

}