package com.example.myapplication.features.movies.moviesList

import com.example.myapplication.R
import com.example.myapplication.core.navigation.Navigator
import com.example.myapplication.core.platform.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MoviesFragment : BaseFragment() {

    @Inject
    lateinit var navigator: Navigator

    override fun layoutId() = R.layout.fragment_movies

}