package com.example.myapplication.core.services

import com.example.myapplication.core.network.MoviesApi
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MoviesService
@Inject constructor(retrofit: Retrofit) : MoviesApi {

    private val moviesApi by lazy { retrofit.create(MoviesApi::class.java) }

    override fun movies() = moviesApi.movies()
}