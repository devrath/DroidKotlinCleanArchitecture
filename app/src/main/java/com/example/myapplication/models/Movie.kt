package com.example.myapplication.models

import com.example.myapplication.core.extension.empty

data class Movie(val id: Int, val poster: String) {
    companion object {
        val empty = Movie(0, String.empty())
    }
}
