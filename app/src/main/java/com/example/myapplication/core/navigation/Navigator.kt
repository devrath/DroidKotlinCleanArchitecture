package com.example.myapplication.core.navigation

import android.content.Context
import com.example.myapplication.features.movies.MoviesActivity
import com.example.myapplication.features.login.Authenticator
import com.example.myapplication.features.login.LoginActivity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Navigator @Inject constructor(private val authenticator: Authenticator) {

    fun showMain(context: Context) {
        when (authenticator.userLoggedIn()) {
            true -> showMovies(context)
            false -> showLogin(context)
        }
    }

    private fun showLogin(context: Context) = context.startActivity(LoginActivity.callingIntent(context))

    private fun showMovies(context: Context) = context.startActivity(MoviesActivity.callingIntent(context))

}