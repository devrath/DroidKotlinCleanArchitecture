package com.example.myapplication.models

import com.example.myapplication.core.extension.empty

/**
 * Movie data class for each movie node
 * @param id ---- > Identifier of the movie
 * @param poster -> Url that has a image stored in the server
 */
data class Movie(val id: Int, val poster: String) {
    companion object {
        val empty = Movie(0, String.empty())
    }
}
