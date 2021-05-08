package com.example.myapplication.core.repositories

import com.example.myapplication.core.exception.Failure
import com.example.myapplication.core.functional.Either
import com.example.myapplication.core.platform.NetworkHandler
import com.example.myapplication.core.services.MoviesService
import com.example.myapplication.models.Movie
import com.example.myapplication.core.exception.Failure.NetworkConnection
import com.example.myapplication.core.exception.Failure.ServerError
import retrofit2.Call
import javax.inject.Inject

interface MoviesRepository {

    fun movies(): Either<Failure, List<Movie>>

    class Network
    @Inject constructor(
            private val networkHandler: NetworkHandler,
            private val service: MoviesService
    ) : MoviesRepository {

        override fun movies(): Either<Failure, List<Movie>> {
            return when (networkHandler.isNetworkAvailable()) {
                true -> request(service.movies(), { it.map { movieEntity -> movieEntity.toMovie() } }, emptyList())
                false -> Either.Left(NetworkConnection)
            }
        }

        private fun <T, R> request(
                call: Call<T>,
                transform: (T) -> R,
                default: T
        ): Either<Failure, R> {
            return try {
                val response = call.execute()
                when (response.isSuccessful) {
                    true -> Either.Right(transform((response.body() ?: default)))
                    false -> Either.Left(ServerError)
                }
            } catch (exception: Throwable) {
                Either.Left(ServerError)
            }
        }
    }

}