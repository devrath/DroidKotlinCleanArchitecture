package com.example.myapplication.features.movies

import android.content.Context
import android.content.Intent
import com.example.myapplication.core.platform.BaseActivity
import com.example.myapplication.features.movies.moviesList.MoviesFragment

class MoviesActivity : BaseActivity() {

    companion object {
        fun callingIntent(context: Context) = Intent(context, MoviesActivity::class.java)
    }

    override fun fragment() = MoviesFragment()
}
