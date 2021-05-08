package com.example.myapplication.models

data class MovieEntity(private val id: Int, private val poster: String) {
    fun toMovie() = Movie(id, poster)
}
