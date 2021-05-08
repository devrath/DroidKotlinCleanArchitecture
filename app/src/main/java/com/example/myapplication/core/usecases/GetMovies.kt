package com.example.myapplication.core.usecases

import com.example.myapplication.core.interactor.UseCase
import com.example.myapplication.core.repositories.MoviesRepository
import com.example.myapplication.models.Movie
import javax.inject.Inject

class GetMovies
@Inject constructor(private val moviesRepository: MoviesRepository) : UseCase<List<Movie>, UseCase.None>() {

    override suspend fun run(params: None) = moviesRepository.movies()
}