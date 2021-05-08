package com.example.myapplication.core.network

import com.example.myapplication.models.Movie
import retrofit2.Call
import retrofit2.http.GET

interface MoviesApi {

    companion object {
        private const val MOVIES = "movies.json"
    }

    @GET(MOVIES)
    fun movies(): Call<List<Movie>>
}