package com.example.myapplication.core.network

import com.example.myapplication.models.Movie
import retrofit2.Call
import retrofit2.http.GET

/**
 * This is a interface used for the retrofit, to list their API's
 */
interface MoviesApi {

    /**
     * A good practice to add the end param in a companion object in the Retrofit API interface instead of directly adding it in each API
     */
    companion object {
        private const val MOVIES = "movies.json"
    }

    @GET(MOVIES)
    fun movies(): Call<List<Movie>>

}